package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>
{
    List<PatientEntity> findByLastName(String lastName);
    List<PatientEntity> findByNumerOfVisits(int visitsNumber);
    List<PatientEntity> findByEmailContaining(String email);
    void addNewVisitEntity(long patientId, long doctorId, LocalDateTime visitDate, String visitDescription);
}
//4. Dodaj metode w PatientDao, ktora na podstawie parametrow wejsciowych:
//
//        ID pacjenta, ID doktora, data wizyty, opis wizyty
//
//utworzy nowa encje wizyty i doda ja do pacjenta w jednym wywolaniu - kaskadowy update pacjenta (merge).
//
//Npisz test do tej metody (Dao)