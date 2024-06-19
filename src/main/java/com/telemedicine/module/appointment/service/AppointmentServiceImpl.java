package com.telemedicine.module.appointment.service;

import com.telemedicine.module.appointment.domain.Appointment;
import com.telemedicine.module.appointment.domain.AppointmentStatus;
import com.telemedicine.module.appointment.repository.AppointmentRepository;
import com.telemedicine.module.doctor.repository.DoctorRepository;
import com.telemedicine.module.notification.NotificationService;
import com.telemedicine.module.patient.domain.Patient;
import com.telemedicine.module.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class AppointmentServiceImpl  implements   AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;


    @Autowired
    private NotificationService notificationService;

    public Appointment scheduleAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.PENDING);
        return appointmentRepository.save(appointment);
    }

    public Appointment approveAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));

        appointment.setStatus(AppointmentStatus.APPROVED);
        appointmentRepository.save(appointment);
        String message = String.format("Reminder: You have an appointment with Dr. %s on %s.",
         doctorRepository.findByUserId(appointment.getDoctorId()).get().getName(),
                appointment.getAppointmentDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

        sendNotification(appointment, "Your appointment has been approved.");

        return appointment;
    }

    public Appointment cancelAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));

        appointment.setStatus(AppointmentStatus.CANCELLED);
        appointmentRepository.save(appointment);

        sendNotification(appointment, "Your appointment has been cancelled.");

        return appointment;
    }

    public Appointment getAppointment(Long appointmentId) {
        return appointmentRepository.findById(appointmentId).orElseThrow(()->new IllegalArgumentException("Appointment not found"));
    }

    @Override
    public List<Appointment> getDoctorAppointment(Long doctor) {
        return appointmentRepository.findByDoctorId(doctor);
    }

    @Override
    public List<Appointment> getPatientAppointment(Long doctor) {
        return appointmentRepository.findByPatientId(doctor);
    }

    @Scheduled(fixedRate = 3600000) // Runs every hour
    public void sendReminders() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime reminderTime = now.plusHours(24);

        List<Appointment> upcomingAppointments = appointmentRepository.findByAppointmentDateBetweenAndStatus(reminderTime, reminderTime.plusHours(1), AppointmentStatus.APPROVED);
        for (Appointment appointment : upcomingAppointments) {
            sendNotification(appointment, "Reminder: You have an appointment tomorrow.");
        }
    }

    private void sendNotification(Appointment appointment, String message) {
        Long patientId = appointment.getPatientId();
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new IllegalArgumentException("Appointment not found"));
        // Send SMS
//        if (patient.getPhone() != null) {
//            notificationService.sendSms(patient.getPhone(), message);
//        }
//        // Send Email
        if (patient.getEmail() != null) {
            notificationService.sendEmail(patient.getEmail(), message,"Appointment Notification" );
        }
    }
}
