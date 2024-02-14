package com.medhead.emergencydispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medhead.emergencydispatcher.domain.entity.GpsCoordinate;

@RestController
public class HomeController {

    @Autowired
    private DistanceMatrixServiceImpl distanceMatrixService;

    /**
    * @return Iterable<Hospital>
    */
    @PostMapping("/findNearest")
    public ResponseEntity<Object> getHospitals(@RequestBody GpsCoordinate gpsCoordinate) {
        // return this.distanceMatrixService.trouverEtablissementLePlusProche(	51.37,-0.4060);
        return this.distanceMatrixService.trouverEtablissementLePlusProche(gpsCoordinate.getLat(), gpsCoordinate.getLng(), gpsCoordinate.getSpeciality());
    }
}
