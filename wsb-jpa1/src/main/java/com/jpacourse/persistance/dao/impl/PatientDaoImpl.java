package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{
    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findByNumerOfVisits(int visitNumb) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p " +
                        "JOIN p.visitEntities v " +
                        "GROUP BY p " +
                        "HAVING COUNT(v) > :visitNumb", PatientEntity.class);
        query.setParameter("visitNumb", (long) visitNumb);
        return query.getResultList();
    }
    @Override
    public List<PatientEntity> findByEmailContaining(String fragment) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p.email LIKE :fragment", PatientEntity.class);
        query.setParameter("fragment", "%" + fragment + "%");
        return query.getResultList();
    }
    @Override
    public Long addNewVisitEntity(long patientId, long doctorId, LocalDateTime visitDate, String visitDescription)
    {
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);
        VisitEntity visit = new VisitEntity();
        visit.setTime(visitDate);
        visit.setDescription(visitDescription);
        visit.setPatientEntity(patient);
        visit.setDoctorEntity(doctor);
        entityManager.persist(visit);
        entityManager.refresh(patient);
        return visit.getId();
    }
}
