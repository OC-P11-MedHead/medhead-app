package com.medhead.emergencymanagement.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medhead.emergencymanagement.domain.entities.Emergency;
import com.medhead.emergencymanagement.infrastructure.repository.EmergencyRepository;

@Service
public class EmergencyService {

    @Autowired
    private EmergencyRepository emergencyRepository;

    
    public Iterable<Emergency> getEmergencies() {
        return this.emergencyRepository.findAll();
    }

    /**
     * @param Emergency
     * @return Emergency
     */
    public Emergency createEmergency(Emergency emergency) {
        return this.emergencyRepository.save(emergency);
    }
}
