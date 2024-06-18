//package com.telemedicine.module.appointment.controller;
//
//
//
//    import com.telemedicine.module.appointment.domain.Appointment;
//    import com.telemedicine.module.appointment.service.AppointmentService;
//    import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//    @RestController
//    @RequestMapping("/api/appointments")
//    public class AppointmentController {
//
//        @Autowired
//        private AppointmentService appointmentService;
//
//        @PostMapping
//        public Appointment scheduleAppointment(@RequestBody Appointment appointment) {
//            return appointmentService.scheduleAppointment(appointment);
//        }
//
//        @PostMapping("/{appointmentId}/approve")
//        public Appointment approveAppointment(@PathVariable Long appointmentId) {
//            return appointmentService.approveAppointment(appointmentId);
//        }
//
//        @PostMapping("/{appointmentId}/cancel")
//        public Appointment cancelAppointment(@PathVariable Long appointmentId) {
//            return appointmentService.cancelAppointment(appointmentId);
//        }
//
//        @GetMapping("/{appointmentId}")
//        public Appointment getAppointment(@PathVariable Long appointmentId) {
//            return appointmentService.getAppointment(appointmentId);
//        }
//    }
//
//
