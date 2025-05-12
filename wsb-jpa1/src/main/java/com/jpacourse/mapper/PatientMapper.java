package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitsDTO;
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
        List<VisitsDTO> visitsDTOList = new ArrayList<>();
        for (VisitEntity visitEntity : patientEntity.getVisitEntities()){
            visitsDTOList.add(VisitMapper.mapToTO(visitEntity));
        }
        patientTO.setVisits(visitsDTOList);
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
        for (VisitsDTO visitsDTO : patientTO.getVisits()){
            visitEntityListEntity.add(VisitMapper.mapToEntity(visitsDTO));
        }
        patientEntity.setVisitEntities(visitEntityListEntity);
        return patientEntity;
    }
}
