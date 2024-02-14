package com.medhead.mshospitalmanagement.application.emergency;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.medhead.mshospitalmanagement.infrastructure.repository.hospital.HospitalJpa;

@Service
public class EmergencyService {

    private final RestTemplate restTemplate;

    public EmergencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void publishEmergency(HospitalJpa hospital, String specialityId) {
         JSONObject emergency = new JSONObject();
            emergency.put("hospitalUuid", hospital.getOrganisationId());
            emergency.put("hospitalName", hospital.getOrganisationName());
            emergency.put("speciality", specialityId);
            emergency.put("origin", "test" );
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<String> (emergency.toString(), headers);

            this.restTemplate.postForObject("http://localhost:9090/emergency", request, String.class);
    }
}
