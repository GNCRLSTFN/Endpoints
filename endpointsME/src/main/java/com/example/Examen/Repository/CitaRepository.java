package com.example.Examen.Repository;

import com.example.Examen.Entity.Cita;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, String> {
    Cita findByDoctor(String doctor);
//    Cita findAllDoctors(String doctor);
    List<Cita> findAll(Sort sort);
}
