package model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String name;
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Doctor admittedBy;

    // Getters y setters
}