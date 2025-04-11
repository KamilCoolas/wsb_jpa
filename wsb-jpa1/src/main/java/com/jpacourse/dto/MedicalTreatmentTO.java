package com.jpacourse.dto;

import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.enums.TreatmentType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

public class MedicalTreatmentTO implements Serializable
{
    private Long id;

    private String description;

    private TreatmentType type;

    private PatientVisitTO visit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TreatmentType getType() {
        return type;
    }

    public void setType(TreatmentType type) {
        this.type = type;
    }

    public PatientVisitTO getVisit() {
        return visit;
    }

    public void setVisit(PatientVisitTO visit) {
        this.visit = visit;
    }
}
