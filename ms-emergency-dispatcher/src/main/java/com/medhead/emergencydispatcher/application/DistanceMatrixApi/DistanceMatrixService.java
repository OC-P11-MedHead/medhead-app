package com.medhead.emergencydispatcher.application.DistanceMatrixApi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.medhead.emergencydispatcher.application.hospital.HospitalService;
import com.medhead.emergencydispatcher.domain.entity.HospitalApi;

@Service
public class DistanceMatrixService {
    
    @Value("${google.maps.api-key}")
    private String apiKey;

    private HospitalService hospitalService;

    private final RestTemplate restTemplate;

    public DistanceMatrixService(RestTemplate restTemplate, HospitalService hospitalService) {
        this.restTemplate = restTemplate; 
        this.hospitalService = hospitalService; 
    }

    public DestinationsResponse getDistanceMatrix(double originLat, double originLng, String speciality) {
        // Construisez l'URL de l'API Distance Matrix avec les paramètres appropriés
        DestinationsResponse destinationsResponse = buildApiUrl(originLat, originLng, speciality);
        String apiUrl = buildApiUrl(originLat, originLng, speciality).stringApi;
        System.out.println(apiUrl + "\n\n\n\n");
        // Effectuez la requête à l'API Distance Matrix
        destinationsResponse.apiResponse = restTemplate.getForObject(apiUrl, DistanceMatrixResponse.class);

        return destinationsResponse;
    }

    private DestinationsResponse buildApiUrl(double originLat, double originLng, String speciality) {
        // Construisez l'URL avec les paramètres nécessaires, y compris la clé API
        // Utilisez la classe UriComponentsBuilder pour construire l'URL de manière sécurisée+
        DestinationsResponse destinationsResponse = buildDestinationsString(speciality);
        destinationsResponse.stringApi = UriComponentsBuilder.fromUriString("https://maps.googleapis.com/maps/api/distancematrix/json")
        .queryParam("origins", originLat + "," + originLng)
            .queryParam("destinations", destinationsResponse.destinations)
            .queryParam("key", apiKey)
            .build()
            .toUriString();

        return destinationsResponse;
    }
    
    public DestinationsResponse buildDestinationsString(String speciality) {
        HospitalApi[] hospitals = this.hospitalService.getHospitals(speciality);
        Map<Integer, Integer> idCoordinateMap = new HashMap<>();
        Integer index = 0;
        String destinations = "";
        for (HospitalApi hospital : hospitals) {
            if (hospital.getEmergencyBedrooms() > 0 ) {
                destinations += hospital.getOrganisationName() + "|";
                idCoordinateMap.put(index, hospital.getOrganisationId());
                index++;
            }
        }
        System.out.println(destinations);
        DestinationsResponse destinationsResponse = new DestinationsResponse();
        destinationsResponse.destinations = destinations;
        destinationsResponse.idCoordinateMap = idCoordinateMap;
        destinationsResponse.hospitals = hospitals;
        destinationsResponse.specialityId = speciality;
        
        return destinationsResponse;
    }
}

