package com.medhead.mshospitalmanagement.infrastructure.repository.hospital;

import java.util.Set;

import com.medhead.mshospitalmanagement.infrastructure.repository.speciality.SpecialityJpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "hospitals")
public class HospitalJpa {
    @Id
	@Column(name="ORGANISATIONID")
	private Long organisationId;
	@Column(name="ORGANISATIONNAME")
	private String organisationName;
	private String address1;
	private String address2;	
	private String city;
	@Column(name="EMERGENCYBEDROOMS")
	public int emergencyBedrooms;
	@Column(name="POSTCODE")
	private String postCode;
	private String latitude;
	private String longitude;
	private String email;
	@ManyToMany
	@JoinTable(
		name="hospitals_speciality",
		joinColumns = @JoinColumn(name="ORGANISATIONID"),
		inverseJoinColumns = @JoinColumn(name="UUID")
	)
	private Set<SpecialityJpa> specialities;
}
