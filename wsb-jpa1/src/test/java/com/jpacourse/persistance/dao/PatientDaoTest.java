package com.jpacourse.persistance.dao;

//import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@Repository
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

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

}
