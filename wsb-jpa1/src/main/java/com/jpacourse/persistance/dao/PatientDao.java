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
    Long addNewVisitEntity(long patientId, long doctorId, LocalDateTime visitDate, String visitDescription);
}