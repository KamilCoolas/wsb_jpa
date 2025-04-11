package com.jpacourse.mapper;

import com.jpacourse.dto.MedicalTreatmentTO;
import com.jpacourse.dto.PatientVisitTO;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import java.util.ArrayList;
import java.util.List;

public final class PatientVisitMapper
{

    public static PatientVisitTO mapToTO(final VisitEntity visitEntity)
    {
        if (visitEntity == null)
        {
            return null;
        }
        final PatientVisitTO patientVisitTO = new PatientVisitTO();
        patientVisitTO.setId(visitEntity.getId());
        patientVisitTO.setDescription(visitEntity.getDescription());
        patientVisitTO.setTime(visitEntity.getTime());
        patientVisitTO.setDoctorFirstName(visitEntity.getDoctorEntity().getFirstName());
        patientVisitTO.setDoctorLastName(visitEntity.getDoctorEntity().getLastName());
        List<MedicalTreatmentTO> medicalTreatmentTOList = new ArrayList<>();
        for (MedicalTreatmentEntity medicalTreatmentEntity : visitEntity.getMedicalTreatmentEntities()) {
            medicalTreatmentTOList.add(MedicalTreatmentMapper.mapToTO(medicalTreatmentEntity));
        }
        patientVisitTO.setMedicalTreatments(medicalTreatmentTOList);
        return patientVisitTO;
    }

    public static VisitEntity mapToEntity(final PatientVisitTO patientVisitTO)
    {
        if(patientVisitTO == null)
        {
            return null;
        }
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(patientVisitTO.getId());
        visitEntity.setDescription(patientVisitTO.getDescription());
        visitEntity.setTime(patientVisitTO.getTime());
        if (visitEntity.getDoctorEntity() != null) {
            DoctorEntity doctorEntity = visitEntity.getDoctorEntity();
            doctorEntity.setFirstName(patientVisitTO.getDoctorFirstName());
            doctorEntity.setLastName(patientVisitTO.getDoctorLastName());
            visitEntity.setDoctorEntity(doctorEntity);
        }
        List<MedicalTreatmentEntity> medicalTreatmentEntityList = new ArrayList<>();
        for (MedicalTreatmentTO medicalTreatmentTO : patientVisitTO.getMedicalTreatments()) {
            medicalTreatmentEntityList.add(MedicalTreatmentMapper.mapToEntity(medicalTreatmentTO));
        }
        visitEntity.setMedicalTreatmentEntities(medicalTreatmentEntityList);
        return visitEntity;
    }
}
