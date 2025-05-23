package com.jpacourse.rest;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.DoctorService;
import com.jpacourse.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController
{

    private final DoctorService doctorService;


    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctor/{id}")
    DoctorTO findBaId(@PathVariable final Long id) {
        final DoctorTO doctor = doctorService.findById(id);
        if(doctor != null)
        {
            return doctor;
        }
        throw new EntityNotFoundException(id);
    }
}
