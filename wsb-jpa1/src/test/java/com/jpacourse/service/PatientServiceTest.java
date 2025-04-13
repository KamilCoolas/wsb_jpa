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

//    @Transactional
//    @Test
//    public void testShouldSaveAndRemovePatient() {
//        // given
//        PatientEntity patientEntity = new PatientEntity();
//        patientEntity.setFirstName("Test");
//        patientEntity.setLastName("Person");
//        patientEntity.setDateOfBirth(LocalDate.parse("1998-12-31"));
//        patientEntity.setPatientNumber("9011");
//        patientEntity.setEmail("email@email");
//        AddressEntity addressEntity = new AddressEntity();
//        addressEntity.setAddressLine1("line1");
//        addressEntity.setAddressLine2("line2");
//        addressEntity.setCity("City1");
//        addressEntity.setPostalCode("66-666");
//        patientEntity.setAddressEntity(addressEntity);
//        patientEntity.setTelephoneNumber("1234");
//        patientEntity.setVisitEntities();
//        // when
//        final AddressEntity saved = addressDao.save(addressEntity);
//        assertThat(saved.getId()).isNotNull();
//        final AddressEntity newSaved = addressDao.findOne(saved.getId());
//        assertThat(newSaved).isNotNull();
//
//        addressDao.delete(saved.getId());
//
//        // then
//        final AddressEntity removed = addressDao.findOne(saved.getId());
//        assertThat(removed).isNull();
//    }
}