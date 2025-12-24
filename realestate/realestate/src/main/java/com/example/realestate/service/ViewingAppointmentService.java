package com.example.realestate.service;

import com.example.realestate.entity.ViewingAppointment;
import com.example.realestate.repository.ViewingAppointmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ViewingAppointmentService {

    private final ViewingAppointmentRepository repository;

    public ViewingAppointmentService(ViewingAppointmentRepository repository) {
        this.repository = repository;
    }

    public ViewingAppointment save(ViewingAppointment appointment) {
        return repository.save(appointment);
    }

    public List<ViewingAppointment> getAll() {
        return repository.findAll();
    }

    public ViewingAppointment getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    // custom queries
    public List<ViewingAppointment> getByProperty(Long propertyId) {
        return repository.findByPropertyId(propertyId);
    }

    public List<ViewingAppointment> getByDate(LocalDate date) {
        return repository.findByAppointmentDate(date);
    }

    public List<ViewingAppointment> getUpcoming() {
        return repository.findUpcomingAppointments();
    }
}
