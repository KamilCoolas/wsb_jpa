package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import jakarta.persistence.EntityManager;
import jakarta.persistence.OptimisticLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.util.AssertionErrors.fail;

@SpringBootTest
@Repository
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;
    @Autowired
    private VisitDao visitDao;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Test
    public void testShouldFindPatientByLastName() {
        // given
        // when
        List<PatientEntity> patients = patientDao.findByLastName("Kaczmarek");
        assertFalse(patients.isEmpty());
        assertEquals("Kaczmarek", patients.get(0).getLastName());
        //then

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
    @Transactional
    @Test
    public void testShouldCheckIfVersioningIsWorkingAndOptimisticLockExceptionIsThrown() {
        // given
        PatientEntity patient = entityManager.find(PatientEntity.class, 1L);
        entityManager.clear();
        PatientEntity patient2 = entityManager.find(PatientEntity.class, 1L);
        // when
        patient.setEmail("abc");
        patient2.setEmail("def");
        entityManager.persist(patient2);
        entityManager.flush();
        entityManager.clear();
        try
        {
            entityManager.merge(patient);
            fail("Expected OptimisticLockException to be thrown");
        } catch (OptimisticLockException e) {
        }
        catch (Exception e)
        {
            fail("Expected OptimisticLockException to be thrown");
        }
    }
}
