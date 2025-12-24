package com.example.realestate.controller;

import com.example.realestate.entity.ViewingAppointment;
import com.example.realestate.service.ViewingAppointmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class ViewingAppointmentController {

    private final ViewingAppointmentService appointmentService;

    public ViewingAppointmentController(ViewingAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // CREATE
    @PostMapping("/create")
    public ViewingAppointment create(@Valid @RequestBody ViewingAppointment appointment) {
        return appointmentService.save(appointment);
    }

    // READ ALL
    @GetMapping("/all")
    public List<ViewingAppointment> getAll() {
        return appointmentService.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ViewingAppointment getById(@PathVariable Long id) {
        return appointmentService.getById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ViewingAppointment update(@PathVariable Long id,
                                     @Valid @RequestBody ViewingAppointment appointment) {
        appointment.setId(id);
        return appointmentService.save(appointment);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        appointmentService.delete(id);
    }

    // ----------- CUSTOM QUERIES -----------

    // 1. Appointments for a specific property
    @GetMapping("/property/{propertyId}")
    public List<ViewingAppointment> getByProperty(@PathVariable Long propertyId) {
        return appointmentService.getByProperty(propertyId);
    }

    // 2. Appointments on a specific date
    @GetMapping("/date/{date}")
    public List<ViewingAppointment> getByDate(@PathVariable String date) {
        return appointmentService.getByDate(LocalDate.parse(date));
    }

    // 3. Upcoming appointments
    @GetMapping("/upcoming")
    public List<ViewingAppointment> getUpcoming() {
        return appointmentService.getUpcoming();
    }
}
