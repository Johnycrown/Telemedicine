package com.telemedicine.module.appointment.controller;



    import com.telemedicine.module.appointment.domain.Appointment;
    import com.telemedicine.module.appointment.service.AppointmentService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/appointments")
    @CrossOrigin(origins = "*")
    public class AppointmentController {

        @Autowired
        private AppointmentService appointmentService;

        @PostMapping
        public ResponseEntity<?> scheduleAppointment(@RequestBody Appointment appointment) {
            return ResponseEntity.ok().body( appointmentService.scheduleAppointment(appointment));
        }

        @PostMapping("/approve/{appointmentId}")
        public ResponseEntity<?> approveAppointment(@PathVariable Long appointmentId) {
            return ResponseEntity.ok(appointmentService.approveAppointment(appointmentId));
        }

        @PostMapping("/cancel/{appointmentId}")
        public ResponseEntity<?> cancelAppointment(@PathVariable Long appointmentId) {
            return ResponseEntity.ok(appointmentService.cancelAppointment(appointmentId));
        }

        @GetMapping("/{appointmentId}")
        public ResponseEntity<?> getAppointment(@PathVariable Long appointmentId) {
            return ResponseEntity.ok(appointmentService.getAppointment(appointmentId));
        }

        @GetMapping("/doctor/{id}")
        public ResponseEntity<?> fetchAppointmentOfDoctor(@PathVariable Long id){
            return ResponseEntity.ok(appointmentService.getDoctorAppointment(id));
        }
        @GetMapping("/patient/{id}")
        public ResponseEntity<?> fetchAppointmentOfPatient(@PathVariable Long id){
            return ResponseEntity.ok(appointmentService.getDoctorAppointment(id));
        }

    }


