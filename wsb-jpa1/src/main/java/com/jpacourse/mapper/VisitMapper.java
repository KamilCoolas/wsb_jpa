package com.jpacourse.mapper;

import com.jpacourse.dto.MedicalTreatmentTO;
import com.jpacourse.dto.VisitsDTO;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import java.util.ArrayList;
import java.util.List;

public final class VisitMapper
{

    public static VisitsDTO mapToTO(final VisitEntity visitEntity)
    {
        if (visitEntity == null)
        {
            return null;
        }
        final VisitsDTO visitsDTO = new VisitsDTO();
        visitsDTO.setId(visitEntity.getId());
        visitsDTO.setDescription(visitEntity.getDescription());
        visitsDTO.setTime(visitEntity.getTime());
        visitsDTO.setDoctorFirstName(visitEntity.getDoctorEntity().getFirstName());
        visitsDTO.setDoctorLastName(visitEntity.getDoctorEntity().getLastName());
        List<MedicalTreatmentTO> medicalTreatmentTOList = new ArrayList<>();
        for (MedicalTreatmentEntity medicalTreatmentEntity : visitEntity.getMedicalTreatmentEntities()) {
            medicalTreatmentTOList.add(MedicalTreatmentMapper.mapToTO(medicalTreatmentEntity));
        }
        visitsDTO.setMedicalTreatments(medicalTreatmentTOList);
        return visitsDTO;
    }

    public static VisitEntity mapToEntity(final VisitsDTO visitsDTO)
    {
        if(visitsDTO == null)
        {
            return null;
        }
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitsDTO.getId());
        visitEntity.setDescription(visitsDTO.getDescription());
        visitEntity.setTime(visitsDTO.getTime());
//        if (visitEntity.getDoctorEntity() != null) {
//            DoctorEntity doctorEntity = visitEntity.getDoctorEntity();
//            doctorEntity.setFirstName(patientVisitTO.getDoctorFirstName());
//            doctorEntity.setLastName(patientVisitTO.getDoctorLastName());
//            visitEntity.setDoctorEntity(doctorEntity);
//        }
        List<MedicalTreatmentEntity> medicalTreatmentEntityList = new ArrayList<>();
        for (MedicalTreatmentTO medicalTreatmentTO : visitsDTO.getMedicalTreatments()) {
            medicalTreatmentEntityList.add(MedicalTreatmentMapper.mapToEntity(medicalTreatmentTO));
        }
        visitEntity.setMedicalTreatmentEntities(medicalTreatmentEntityList);
        return visitEntity;
    }
}
