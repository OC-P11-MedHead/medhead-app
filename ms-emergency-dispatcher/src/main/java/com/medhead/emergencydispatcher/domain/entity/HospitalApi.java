package com.medhead.emergencydispatcher.domain.entity;

import lombok.Data;

@Data
public class HospitalApi {
    public Integer organisationId;
    public String organisationName;
    public int emergencyBedrooms;
    public String latitude;
    public String longitude; 
}
