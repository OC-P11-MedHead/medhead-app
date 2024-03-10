package com.medhead.emergencydispatcher.application.hospital;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.medhead.emergencydispatcher.domain.entity.HospitalApi;

@Service
public class HospitalService {
    
    @Value("${ms-hospital-management-api}")
    private String getHospitalsBySpecialityEndpoint;

    private final RestTemplate restTemplate;

    public HospitalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HospitalApi[] getHospitals(String specialityId) {
        return this.restTemplate.getForObject(getHospitalsBySpecialityEndpoint + "/hospitals/speciality/id=" + specialityId, HospitalApi[].class);
    }

}
