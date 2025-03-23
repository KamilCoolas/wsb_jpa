package com.jpacourse.persistance.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "TIME", nullable = false)
	private LocalDateTime time;

	@ManyToMany
	@JoinTable(
			name = "VISIT_TO_DOCTOR",
			joinColumns = @JoinColumn(name = "VISIT_ID"),
			inverseJoinColumns = @JoinColumn(name = "DOCTOR_ID")
	)
	private Collection<DoctorEntity> doctorEntities;

	@ManyToMany
	@JoinTable(
			name = "VISIT_TO_PATIENT",
			joinColumns = @JoinColumn(name = "VISIT_ID"),
			inverseJoinColumns = @JoinColumn(name = "PATIENT_ID")
	)
	private Collection<PatientEntity> patientEntities;

	@OneToMany (mappedBy = "visitEntity")
	private Collection<MedicalTreatmentEntity> medicalTreatmentEntities;

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

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Collection<DoctorEntity> getDoctorEntities() {
		return doctorEntities;
	}

	public void setDoctorEntities(Collection<DoctorEntity> doctorEntities) {
		this.doctorEntities = doctorEntities;
	}

	public Collection<PatientEntity> getPatientEntities() {
		return patientEntities;
	}

	public void setPatientEntities(Collection<PatientEntity> patientEntities) {
		this.patientEntities = patientEntities;
	}

	public Collection<MedicalTreatmentEntity> getMedicalTreatmentEntities() {
		return medicalTreatmentEntities;
	}

	public void setMedicalTreatmentEntities(Collection<MedicalTreatmentEntity> medicalTreatmentEntities) {
		this.medicalTreatmentEntities = medicalTreatmentEntities;
	}

}
