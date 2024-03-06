package com.medhead.mshospitalmanagement.application.hospital;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medhead.mshospitalmanagement.infrastructure.repository.hospital.HospitalJpa;
import com.medhead.mshospitalmanagement.infrastructure.repository.hospital.HospitalJpaRepository;

@Service
public class HospitalServiceImpl implements HospitalService<Iterable<HospitalJpa>,Optional<HospitalJpa>> {

    @Autowired
    private HospitalJpaRepository hospitalRepository;

    @Override
    public Iterable<HospitalJpa> getHospitals() {
        return this.hospitalRepository.findAll();
    }

    @Override
    public Iterable<HospitalJpa> findHospitalsBySpeciality(String uuid) {
        // ex :An esthésie  : 455rez4jfir
        return this.hospitalRepository.findHospitalsBySpeciality(uuid);
    }

    @Override
    public Optional<HospitalJpa> getHospital(final Long id) {
        return this.hospitalRepository.findById(id);
    }

    public HospitalJpa save(HospitalJpa hospital) {
        return this.hospitalRepository.save(hospital);
    }
}
