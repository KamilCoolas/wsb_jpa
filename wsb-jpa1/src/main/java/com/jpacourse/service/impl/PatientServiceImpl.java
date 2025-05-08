package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao)
    {
        patientDao = pPatientDao;
    }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }
    @Override
    public PatientTO findBySurname(String surname) {
        List<PatientEntity> PatientList = patientDao.findAll();
        PatientEntity ourpatient = new PatientEntity();
        for (PatientEntity patientEntity : PatientList){
            String target = patientEntity.getLastName();
            if(target.equals(surname)) {
                ourpatient = patientEntity;
                break;
                }
            }

        return PatientMapper.mapToTO(ourpatient);
    }
}
