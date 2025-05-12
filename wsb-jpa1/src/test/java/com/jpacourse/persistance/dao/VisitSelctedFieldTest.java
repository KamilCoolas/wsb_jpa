package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.dao.impl.PatientDaoImpl;
import com.jpacourse.persistance.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

@DataJpaTest
@Import(PatientDaoImpl.class)
class VisitSelectedFieldTest {

    @Autowired
    private PatientDaoImpl patientDao;

    @Test
    void testFindByEmailContaining_DoesNotThrowException() {
        assertThatNoException().isThrownBy(() -> {
            List<PatientEntity> result = patientDao.findByEmailContaining("example");
            System.out.println("Znaleziono pacjentów: " + result.size());
        });
    }

    @Test
    void testFindByEmailContaining_ReturnsPatients() {
        //test
        List<PatientEntity> result = patientDao.findByEmailContaining("example");
        System.out.println("Znaleziono pacjentów: " + result.size());

        //when
        assertThat(result).isNotEmpty();

        //then
        for (PatientEntity patient : result) {
            assertThat(patient.getEmail()).contains("example");
        }
    }
}
