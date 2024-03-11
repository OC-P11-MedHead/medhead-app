package com.medhead.mshospitalmanagement.application.emergency;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.medhead.mshospitalmanagement.infrastructure.repository.hospital.HospitalJpa;

@Service
public class EmergencyService {

    private final RestTemplate restTemplate;
    
    @Value("${ms-emergency-management}")
    private String apiUrl;

    public EmergencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void publishEmergency(HospitalJpa hospital, String specialityId, String apikey) {
         JSONObject emergency = new JSONObject();
            emergency.put("hospitalUuid", hospital.getOrganisationId());
            emergency.put("hospitalName", hospital.getOrganisationName());
            emergency.put("speciality", specialityId);
            emergency.put("origin", "test" );
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<String> (emergency.toString(), headers);
            System.out.println(apiUrl + "/emergency/apikey=" + apikey);
            this.restTemplate.postForObject(apiUrl + "/emergency/apikey=" + apikey, request, String.class);
    }
}
