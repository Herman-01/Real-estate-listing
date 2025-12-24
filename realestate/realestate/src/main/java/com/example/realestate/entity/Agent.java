package com.example.realestate.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Agent name cannot be empty")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "license_id")
    private License license;
}
