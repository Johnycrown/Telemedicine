package com.telemedicine.module.appointment.service;

import com.telemedicine.module.appointment.domain.Appointment;

import java.util.List;

public interface AppointmentService {

    public Appointment scheduleAppointment(Appointment appointment);

    public Appointment approveAppointment(Long appointmentId);

    public Appointment cancelAppointment(Long appointmentId);
    public Appointment getAppointment(Long appointmentId);
    List<Appointment>   getDoctorAppointment(Long doctor);
    List<Appointment>   getPatientAppointment(Long doctor);


}

