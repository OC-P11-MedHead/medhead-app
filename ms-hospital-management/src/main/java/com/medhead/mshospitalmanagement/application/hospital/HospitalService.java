package com.medhead.mshospitalmanagement.application.hospital;


import com.medhead.mshospitalmanagement.infrastructure.repository.hospital.HospitalJpa;

public interface HospitalService<R1, R2> {
    R1 getHospitals();     
    R1 findHospitalsBySpeciality(String uuid);    
    R2 getHospital(Long id);
    HospitalJpa save(HospitalJpa hospital);
}