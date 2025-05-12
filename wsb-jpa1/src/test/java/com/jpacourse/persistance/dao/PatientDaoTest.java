package com.jpacourse.persistance.dao;

//import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@Repository
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;
    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Test
    public void testShouldFindPatientByLastName() {
        // given
        // when
        List<PatientEntity> patients = patientDao.findByLastName("Kaczmarek");
        assertFalse(patients.isEmpty());
        assertEquals("Kaczmarek", patients.get(0).getLastName());
        //then

       // assertThat(patientTO).isNotNull();
       // assertThat(patientTO.getClass()).isEqualTo("Kaczmarek");

    }
    @Transactional
    @Test
    public void testShouldCreateNewVisitEntityAndAddItToPatient() {
        // given
        LocalDateTime now = LocalDateTime.now();
        // when
        Long newVisitId = patientDao.addNewVisitEntity(1L,1L, now , "Description1");
        VisitEntity visit = visitDao.findOne(newVisitId);
        PatientEntity patient = patientDao.findOne(1L);
        Collection<VisitEntity> visitList = patient.getVisitEntities();
        //then
        assertThat(visitList).anyMatch(v -> (v.getId()).equals(newVisitId));
    }

    }
