package com.example.Examen.Service;

import com.example.Examen.DTO.CitaDTO;
import com.example.Examen.Entity.Cita;
import com.example.Examen.Repository.CitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CitaService {
    private final CitaRepository citaRepository;

    @Autowired
    private final JdbcTemplate jdbcTemplate;


    public List<Cita> getAllAppointment(){
        return citaRepository.findAll();
    }

    public Map<String, List<String>> getDoctorAndPatiente(){

        String sql = "SELECT  doctor, patient FROM data";

        Map<String, List<String>> DaP = new HashMap<>();

        jdbcTemplate.query(sql, rs -> {
            String nameDoc = rs.getString("doctor");
            String namePat = rs.getString("patient");

            DaP.putIfAbsent(nameDoc, new ArrayList<>());

            DaP.get(nameDoc).add(namePat);
        });

        return DaP;

    }

    public List<Map<String, Object>> getAppointmentOrdered(String doctor) {

        String sql = "SELECT id, doctor, patient, startTime, endTime " +
                "FROM data " +
                "WHERE doctor = ? " +
                "ORDER BY startTime DESC";

        return jdbcTemplate.queryForList(sql, doctor);
    }

}
