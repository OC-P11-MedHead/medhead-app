package com.medhead.mshospitalmanagement.domain.entities;

import java.util.List;

public class Hospital {
	public Long organisationId;
	public String organisationName;
	public String address1;
	public int emergencyBedrooms;
	public String address2;	
	public String city;
	public String postCode;
	public String latitude;
	public String longitude;
	public String email;
	public List<Speciality> specialities;
}
