package com.jpacourse.persistance.entity;

import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_entity", referencedColumnName = "id")
	private AddressEntity addressEntity;

	@Column(name = "FIRST_NAME ",nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME ",nullable = false)
	private String lastName;

	@Column(name = "TELEPHONE_NUMBER",nullable = false)
	private String telephoneNumber;

	@Column(name = "EMAIL",nullable = false)
	private String email;

	@Column(name = "PATIENT_NUMBER", nullable = false)
	private String patientNumber;

	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;

	@ManyToMany(mappedBy = "patientEntities")
	private Collection<VisitEntity> visitEntities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}
	public Collection<VisitEntity> getVisitEntities() {
		return visitEntities;
	}

	public void setVisitEntities(Collection<VisitEntity> visitEntities) {
		this.visitEntities = visitEntities;
	}

}
