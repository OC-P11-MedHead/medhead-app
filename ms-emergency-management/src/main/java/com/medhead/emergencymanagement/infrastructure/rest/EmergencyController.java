package com.medhead.emergencymanagement.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medhead.emergencymanagement.application.EmergencyService;
import com.medhead.emergencymanagement.domain.entities.Emergency;


@RestController
public class EmergencyController {
    
    @Autowired
    private EmergencyService emergencyService;

    @Value("${secure-key}")
    private String apikey;

    @GetMapping("/emergencies")
    public Iterable<Emergency> getEmergencies() {
        return this.emergencyService.getEmergencies();
    }

    @PostMapping("/emergency/apikey={apikey}")
    public ResponseEntity<Emergency> create(@RequestBody Emergency emergency, @PathVariable("apikey") final String secureKey) {
        // System.out.println(emergency);
        System.out.println(secureKey);
        System.out.println(apikey);
        
        if (!secureKey.equals(apikey)) {
            System.out.println("Clé invalide");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } 
        this.emergencyService.createEmergency(emergency);
        return ResponseEntity.ok(emergency);
        
    }

}
