package com.medhead.emergencydispatcher;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DistanceMatrixServiceImpl {
    @Autowired
    private final DistanceMatrixService distanceMatrixService;

    private final RestTemplate restTemplate;

    public DistanceMatrixServiceImpl(DistanceMatrixService distanceMatrixService, RestTemplate restTemplate) {
        this.distanceMatrixService = distanceMatrixService;
        this.restTemplate = restTemplate;
    }

    /**
     * 
     * @param originLat
     * @param originLng
     * @return
     */
    public ResponseEntity<Object> trouverEtablissementLePlusProche(double originLat, double originLng, String speciality) {
        // Obtenez la matrice de distance depuis l'API Distance Matrix
        DestinationsResponse response = distanceMatrixService.getDistanceMatrix(originLat, originLng, speciality);
        
        // return distanceMatrixService.buildDestinationsString();
        // Analysez la réponse pour trouver l'établissement le plus proche
        System.out.println(response);
        if (response.apiResponse.getRows() != null) {
            for (DistanceMatrixResponse.Row row : response.apiResponse.getRows()) {
                if (row.getElements() != null) {
                    for (DistanceMatrixResponse.Row.Element element : row.getElements()) {
                        System.out.println("Element Status: " + element.getStatus());
                        
                        if (element.getDistance() != null) {
                            System.out.println("Distance Text: " + element.getDistance().getText());
                            System.out.println("Distance Value: " + element.getDistance().getValue());
                        }
                        if (element.getDuration() != null) {
                            System.out.println("Duration Text: " + element.getDuration().getText());
                            System.out.println("Duration Value: " + element.getDuration().getValue() + "\n\n\n");
                        }
                        
                        // Vous pouvez accéder à d'autres propriétés selon votre structure
                    }
                }
            }
        }
        // Implémentez la logique nécessaire ici
        System.out.println(this.findShortestDurationElement(response));
        Map<String, String> responseJson = new HashMap<>();
        responseJson.put("message", "ok");
        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }

    public DistanceMatrixResponse.Row.Element findShortestDurationElement(DestinationsResponse response) {
        DistanceMatrixResponse.Row.Element shortestDurationElement = null;
        int idHospital = -1;
        int indexProche = -1;
        long shortestDuration = Long.MAX_VALUE;
        if (response.apiResponse.getRows() != null) {
            for (DistanceMatrixResponse.Row row : response.apiResponse.getRows()) {
                if (row.getElements() != null) {
                    // for (DistanceMatrixResponse.Row.Element element : row.getElements()) {
                    //     if ("OK".equals(element.getStatus()) && element.getDuration() != null) {
                    //         long durationValue = element.getDuration().getValue();
                    //         if (durationValue < shortestDuration) {
                    //             shortestDuration = durationValue;
                    //             shortestDurationElement = element;
                    //         }
                    //     }
                    // }

                    for (int i = 0; i < row.getElements().size(); i++) {
                        DistanceMatrixResponse.Row.Element element = row.getElements().get(i);
                        if ("OK".equals(element.getStatus()) && element.getDuration() != null) {
                            long durationValue = element.getDuration().getValue();
                            
                            if (durationValue < shortestDuration) {
                                // TO DO : Parser la réponse de l'api Hospital
                                shortestDuration = durationValue;
                                shortestDurationElement = element;
                                indexProche = i;
                                System.out.println(indexProche);
                                // id Hospital le plus proche
                                idHospital = response.idCoordinateMap.get(indexProche);
                                System.out.println(idHospital);
                            }
                        }
                    }
                }
            }
            // Destinations
            if (indexProche == -1) {
                System.err.println("Aucun hôpital n'a été trouvé");
            } else {
                System.out.println(indexProche + " ==> " + response.apiResponse.getDestinationAddresses().get(indexProche));
                this.restTemplate.getForObject("http://localhost:9000/hospitals/id=" + idHospital + "/bookbed/speciality=" + response.specialityId, String.class);
                System.out.println("requete envoye avec id hopital ==> " + idHospital);
            }
           
        }
        return shortestDurationElement;
    }
}
