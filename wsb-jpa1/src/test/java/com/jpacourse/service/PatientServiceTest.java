package com.jpacourse.service;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitsDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class PatientServiceTest {

    @Autowired
    private PatientService patientService;
    @Autowired
    private VisitService visitService;
    @Autowired
    private DoctorService doctorService;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        // when
        PatientTO patientTO = patientService.findById(1L);
        // then
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getExternalId()).isEqualTo(15L);
    }
    @Transactional
    @Test
    public void testIfPatientDeletedCascade() {
        // given
        // when
        PatientTO patientTOBefore = patientService.findById(1L);
        List<VisitsDTO> visitsDTOListBefore = visitService.patientVisits(1L);
        DoctorTO doctorTOBefore = doctorService.findById(1L);
        patientService.deleteById(1L);
        PatientTO patientTO = patientService.findById(1L);
        List<VisitsDTO> visitsDTOList = visitService.patientVisits(1L);
        DoctorTO doctorTO = doctorService.findById(1L);
        // then
        assertThat(visitsDTOList).isEmpty();
        assertThat(patientTO).isNull();
        assertThat(doctorTO).isNotNull();
    }
}