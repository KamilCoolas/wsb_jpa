package com.jpacourse.service;

import com.jpacourse.dto.VisitsDTO;

import java.util.List;

public interface VisitService {
    List<VisitsDTO> patientVisits(Long id);
}
