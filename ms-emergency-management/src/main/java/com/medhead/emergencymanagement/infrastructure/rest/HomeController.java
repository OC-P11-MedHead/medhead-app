package com.medhead.emergencymanagement.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medhead.emergencymanagement.application.EmergencyService;
import com.medhead.emergencymanagement.domain.entities.Emergency;


@RestController
public class HomeController {
    
    @Autowired
    private EmergencyService emergencyService;

    /**
    * Retourne la liste des urgences en cours
    */
    @GetMapping("/emergencies")
    public Iterable<Emergency> getEmergencies() {
        return this.emergencyService.getEmergencies();
    }

    @PostMapping("/emergency")
    public Emergency create(@RequestBody Emergency emergency) {
        System.out.println(emergency);
        return this.emergencyService.createEmergency(emergency);
    }

}
