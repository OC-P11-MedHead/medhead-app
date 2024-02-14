package com.medhead.mshospitalmanagement.domain.usecases;

import java.util.List;

import com.medhead.mshospitalmanagement.domain.entities.Hospital;

public class GetHospitalsBySpeciality {
    private final HospitalPort hospitalPort;

    public GetHospitalsBySpeciality (HospitalPort hospitalPort) {
        this.hospitalPort = hospitalPort;
    }

    public List<Hospital> execute() {
        return hospitalPort.getAllBySpecialty();
    }
}
