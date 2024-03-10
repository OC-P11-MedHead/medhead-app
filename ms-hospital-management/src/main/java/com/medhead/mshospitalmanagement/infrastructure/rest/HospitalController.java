package com.medhead.mshospitalmanagement.infrastructure.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.medhead.mshospitalmanagement.application.emergency.EmergencyService;
import com.medhead.mshospitalmanagement.application.hospital.HospitalServiceImpl;
import com.medhead.mshospitalmanagement.application.speciality.SpecialityServiceImpl;
import com.medhead.mshospitalmanagement.domain.usecases.GetAllHospitals;
import com.medhead.mshospitalmanagement.infrastructure.repository.hospital.HospitalJpa;
import com.medhead.mshospitalmanagement.infrastructure.repository.speciality.SpecialityJpa;

@RestController
public class HospitalController {

    @Autowired
    private HospitalServiceImpl hospitalService;    

    @Autowired
    private EmergencyService emergencyService;    
    
    @Autowired
    private SpecialityServiceImpl specialityService;

    public GetAllHospitals getAllHospitals;
    

    /**
    * @return Iterable<Hospital>
    */
    @GetMapping("/hospitals")
    public Iterable<HospitalJpa> getHospitals() {
        return this.hospitalService.getHospitals();
    }
    
    /**
    * Read - e
    * @return - Iterable<SpecialityJpa>
    */
    @GetMapping("/specialities")
    public Iterable<SpecialityJpa> getSpecialities() {
        return this.specialityService.getSpecialities();
    }

    /**
    * Read - e
    * @return - Iterable<HospitalJpa>
    */
    @GetMapping("/hospitals/speciality/id={id}")
    public Iterable<HospitalJpa> findHospitalsBySpeciality(@PathVariable("id") final String uuid) {
        return this.hospitalService.findHospitalsBySpeciality(uuid);
    }


    @GetMapping("/hospitals/id={id}/bookbed/speciality={speciality}")
    public String bookBed(@PathVariable("id")final Long uuid, @PathVariable("speciality") final String specialityId) {
        Optional<HospitalJpa> optionalHospital = this.hospitalService.getHospital(uuid);
        if (optionalHospital.isPresent()) {
            HospitalJpa hospital = optionalHospital.get();
            Integer numberOfBed = hospital.getEmergencyBedrooms();
            hospital.setEmergencyBedrooms(numberOfBed - 1);
            System.out.println("hopital mis a jour");
            
            this.hospitalService.save(hospital);
            this.emergencyService.publishEmergency(hospital, specialityId);
            // Rajout de la librairie JSON 
            // TO DO A faire la requete vers ms emergency manangement
            // pour créer l'urgence 
           
            return "Mise a jour de l'hopital avec id ===> " + uuid;
        }
        System.out.println("erreur est survenu");
        return "une erreur est survenu";
    }
}