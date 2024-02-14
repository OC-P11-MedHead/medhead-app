package com.medhead.emergencydispatcher;

import java.util.Map;

public class DestinationsResponse {
    public String destinations;
    public String specialityId;
    public String stringApi;
    public HospitalApi[] hospitals;
    public Map<Integer, Integer> idCoordinateMap;
    public DistanceMatrixResponse apiResponse;
}
