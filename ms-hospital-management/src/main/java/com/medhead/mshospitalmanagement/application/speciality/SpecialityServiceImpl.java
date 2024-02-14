package com.medhead.mshospitalmanagement.application.speciality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medhead.mshospitalmanagement.infrastructure.repository.speciality.SpecialityJpa;
import com.medhead.mshospitalmanagement.infrastructure.repository.speciality.SpecialityJpaRepository;

@Service
public class SpecialityServiceImpl implements SpecialityService<Iterable<SpecialityJpa>> {
    
    @Autowired
    private SpecialityJpaRepository specialityJpaRepository;

    @Override
    public Iterable<SpecialityJpa> getSpecialities() {
        return this.specialityJpaRepository.findAll();
    }
}
