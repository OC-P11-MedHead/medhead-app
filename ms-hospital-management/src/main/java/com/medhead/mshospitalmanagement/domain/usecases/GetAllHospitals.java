package com.medhead.mshospitalmanagement.domain.usecases;

import java.util.List;

import com.medhead.mshospitalmanagement.domain.entities.Hospital;

public class GetAllHospitals {

    private final HospitalPort hospitalPort;

    public GetAllHospitals (HospitalPort hospitalPort) {
        this.hospitalPort = hospitalPort;
    }

    public List<Hospital> execute() {
        return hospitalPort.getAll();
    }
}
