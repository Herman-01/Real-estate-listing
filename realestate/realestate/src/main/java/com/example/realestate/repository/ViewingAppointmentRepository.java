package com.example.realestate.repository;
import com.example.realestate.entity.ViewingAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ViewingAppointmentRepository extends JpaRepository<ViewingAppointment, Long> {

    // 7. Appointments for a property
    List<ViewingAppointment> findByPropertyId(Long propertyId);

    // 8. Appointments on a specific date
    List<ViewingAppointment> findByAppointmentDate(LocalDate date);

    // 9. Upcoming appointments
    @Query("SELECT a FROM ViewingAppointment a WHERE a.appointmentDate >= CURRENT_DATE")
    List<ViewingAppointment> findUpcomingAppointments();
}
