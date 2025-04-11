package com.jpacourse.mapper;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.dto.MedicalTreatmentTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.PatientVisitTO;
import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.util.ArrayList;
import java.util.List;

public final class PatientMapper
{

    public static PatientTO mapToTO(final PatientEntity patientEntity)
    {
        if (patientEntity == null)
        {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setExternalId(patientEntity.getExternalId());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setAddress(AddressMapper.mapToTO(patientEntity.getAddressEntity()));
        List<PatientVisitTO> PatientVisitTOList = new ArrayList<>();
        for (VisitEntity visitEntity : patientEntity.getVisitEntities()){
            PatientVisitTOList.add(PatientVisitMapper.mapToTO(visitEntity));
        }
        patientTO.setVisits(PatientVisitTOList);
        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO)
    {
        if(patientTO == null)
        {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setExternalId(patientTO.getExternalId());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setAddressEntity(AddressMapper.mapToEntity(patientTO.getAddress()));
        List<VisitEntity> visitEntityListEntity = new ArrayList<>();
        for (PatientVisitTO patientVisitTO : patientTO.getVisits()){
            visitEntityListEntity.add(PatientVisitMapper.mapToEntity(patientVisitTO));
        }
        return patientEntity;
    }
}
