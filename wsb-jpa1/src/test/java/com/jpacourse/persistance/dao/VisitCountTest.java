package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.dao.impl.PatientDaoImpl;
import com.jpacourse.persistance.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;

@DataJpaTest
@Import(PatientDaoImpl.class)
class VisitCountTest {

    @Autowired
    private PatientDaoImpl patientDao;

    @Test
    void testFindByNumerOfVisits_DoesNotThrowException() {
        assertThatNoException().isThrownBy(() -> {
            List<PatientEntity> result = patientDao.findByNumerOfVisits(1);
            System.out.println("Znaleziono pacjentów: " + result.size());
        });
    }
}
