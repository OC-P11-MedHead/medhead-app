package com.medhead.emergencydispatcher.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medhead.emergencydispatcher.application.DistanceMatrixApi.DistanceMatrixServiceImpl;
import com.medhead.emergencydispatcher.domain.entity.GpsCoordinate;

@RestController
public class EmergencyDispatcherController {

    @Autowired
    private DistanceMatrixServiceImpl distanceMatrixService;

    @Value("${secure-key}")
    private String secureKey;
    /**
    * @return Iterable<Hospital>
    */
    @PostMapping("/findNearest&apikey={apikey}")
    public ResponseEntity<Object> getHospitals(
        @RequestBody GpsCoordinate gpsCoordinate,
        @PathVariable("apikey") final String apiKey
    ) {
        if (!secureKey.equals(apiKey)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return this.distanceMatrixService.trouverEtablissementLePlusProche(gpsCoordinate.getLat(), gpsCoordinate.getLng(), gpsCoordinate.getSpeciality());
    }
}
