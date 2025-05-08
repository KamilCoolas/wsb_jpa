package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;

import java.time.LocalDate;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>
{
    List<PatientEntity> findByLastName(String lastName);
    List<PatientEntity> findByNumerOfVisits(int visitsNumber);
    List<PatientEntity> findByEmailContaining(String email);
}
