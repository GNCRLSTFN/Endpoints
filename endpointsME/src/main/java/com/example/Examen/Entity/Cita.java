package com.example.Examen.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "Data")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "doctor", nullable = false)
    private String doctor;
    @Column(name = "patient", nullable = false)
    private String patient;
    @Column(name = "date", nullable = false)
    private String date;
    @Column(name = "startTime", nullable = false)
    private String startTime;
    @Column(name = "endTime", nullable = false)
    private String endTime;
}
