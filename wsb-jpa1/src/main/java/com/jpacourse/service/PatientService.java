package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;

public interface PatientService {

    void deletePatient(Long id);

    PatientTO getPatient(Long id);
}
