package com.medhead.emergencydispatcher.application.DistanceMatrixApi;

import java.util.Map;

import com.medhead.emergencydispatcher.domain.entity.HospitalApi;

public class DestinationsResponse {
    public String destinations;
    public String specialityId;
    public String stringApi;
    public HospitalApi[] hospitals;
    public Map<Integer, Integer> idCoordinateMap;
    public DistanceMatrixResponse apiResponse;
}
