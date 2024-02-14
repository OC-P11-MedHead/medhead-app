package com.medhead.mshospitalmanagement.infrastructure.repository.speciality;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SPECIALITY")
public class SpecialityJpa {
    @Id
    @Column(name="UUID")
    private String uuid;    
    private String libelle;
}
