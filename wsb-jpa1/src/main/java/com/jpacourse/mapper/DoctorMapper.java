package com.jpacourse.mapper;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitsDTO;
import com.jpacourse.persistance.entity.DoctorEntity;

import java.util.ArrayList;
import java.util.List;

public final class DoctorMapper
{

    public static DoctorTO mapToTO(final DoctorEntity doctorEntity)
    {
        if (doctorEntity == null)
        {
            return null;
        }
        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        return doctorTO;
    }

    public static DoctorEntity mapToEntity(final DoctorTO doctorTO)
    {
        if(doctorTO == null)
        {
            return null;
        }
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorTO.getId());
        return doctorEntity;
    }
}
