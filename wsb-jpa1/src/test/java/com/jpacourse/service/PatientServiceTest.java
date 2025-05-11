package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class PatientServiceTest {

    @Autowired
    private PatientService patientService;

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
        patientService.deleteById(1L);
        PatientTO patientTO = patientService.findById(1L);
        // then
        assertThat(patientTO).isNull();
    }
}