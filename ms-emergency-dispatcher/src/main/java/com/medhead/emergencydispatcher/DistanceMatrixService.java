package com.medhead.emergencydispatcher;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.medhead.emergencydispatcher.application.hospital.HospitalService;

@Service
public class DistanceMatrixService {
    
    @Value("${google.maps.api-key}")
    private String apiKey;

    @Value("${ms-hospital-management-api}")
    private String apiHospital;

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
        // Construisez la chaîne de destinations à partir de la liste de coordonnées
        // DistanceMatrixResponse hospitals = this.restTemplate.getForObject(apiHospital, DistanceMatrixResponse.class);
        // par exemple, "latitude1,longitude1|latitude2,longitude2|..."
        // List<Map<String,Object>> result = restTemplate.getForObject(apiHospital, List.class);
        HospitalApi[] hospitals = this.hospitalService.getHospitals(speciality);
        Map<Integer, Integer> idCoordinateMap = new HashMap<>();
        Integer index = 0;
        String destinations = "";
        for (HospitalApi hospital : hospitals) {
            // destinations += hospital.getLatitude() + "," + hospital.getLongitude() + "|";
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
        // must return
        // { num:1, idhospital: 4d4sd5s, adresse : }


        // return destinations.stream()
        //     .map(latlng -> latlng.getLatitude() + "," + latlng.getLongitude())
        //     .collect(Collectors.joining("|"));
    }
}

