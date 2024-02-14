package com.medhead.emergencymanagement.domain.entities;

import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="emergency")
public class Emergency {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name="UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    public UUID uuid;
    @Column(name="HOSPITALUUID")
    public String hospitalUuid;
    @Column(name="HOSPITALNAME")
    public String hospitalName;
    public String speciality;
    public String origin;
}
