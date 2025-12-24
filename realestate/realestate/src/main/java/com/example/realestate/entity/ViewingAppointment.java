package com.example.realestate.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViewingAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Appointment date is required")
    @FutureOrPresent(message = "Appointment date cannot be in the past")
    private LocalDate appointmentDate;

    @ManyToOne
    @JoinColumn(name = "property_id")
    @NotNull(message = "Property must be selected")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    @NotNull(message = "Buyer must be selected")
    private Buyer buyer;
}
