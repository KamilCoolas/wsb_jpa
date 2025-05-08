/*
package com.jpacourse.persistance.dao;

@DataJpaTest
public class PatientDaoTest {

    @Autowired
    private PatientRepository patientRepository;

    @BeforeEach
    public void setUp() {
        // Przygotowanie danych testowych
        PatientEntity patient1 = new PatientEntity();
        patient1.setFirstName("Jan");
        patient1.setLastName("Kowalski");
        patientRepository.save(patient1);

        PatientEntity patient2 = new PatientEntity();
        patient2.setFirstName("Anna");
        patient2.setLastName("Nowak");
        patientRepository.save(patient2);

        PatientEntity patient3 = new PatientEntity();
        patient3.setFirstName("Kamil");
        patient3.setLastName("Kowalski");
        patientRepository.save(patient3);
    }

    @Test
    public void testFindByLastName() {
        // Testowanie metody findByLastName
        List<PatientEntity> kowalskiPatients = patientRepository.findByLastName("Kowalski");

        // Sprawdzamy, czy metoda zwraca odpowiednich pacjentów
        assertThat(kowalskiPatients).hasSize(2);
        assertThat(kowalskiPatients).anyMatch(patient -> patient.getLastName().equals("Kowalski"));
    }
}
*/
