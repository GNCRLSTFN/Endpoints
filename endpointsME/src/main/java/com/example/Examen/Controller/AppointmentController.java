package com.example.Examen.Controller;

import com.example.Examen.Entity.Cita;
import com.example.Examen.Service.CitaService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    @Autowired
    private final CitaService citaService;


    @GetMapping("/find/all")
    public ResponseEntity<List<Cita>>getAll() throws BadRequestException {
        try{
            return ResponseEntity.ok(citaService.getAllAppointment());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/find/findDoctAndPat")
    public ResponseEntity <Map<String, List<String>>> getList(){
        try {
            return ResponseEntity.ok(citaService.getDoctorAndPatiente());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/find/start/{doctor}")
    public ResponseEntity<List<Map<String, Object>>> getDocByStartTime(@PathVariable String doctor){
        try {
            return ResponseEntity.ok(citaService.getAppointmentOrdered(doctor));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
