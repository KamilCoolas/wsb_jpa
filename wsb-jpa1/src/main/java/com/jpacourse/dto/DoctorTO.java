package com.jpacourse.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

public class DoctorTO implements Serializable
{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
