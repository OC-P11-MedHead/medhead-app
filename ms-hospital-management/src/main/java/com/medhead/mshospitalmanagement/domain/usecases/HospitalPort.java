package com.medhead.mshospitalmanagement.domain.usecases;

import java.util.List;
import com.medhead.mshospitalmanagement.domain.entities.Hospital;

public interface HospitalPort {
    public List<Hospital> getAll();    
    public List<Hospital> getAllBySpecialty();
    public Hospital getById();
    public Hospital save();
    public void delete();
    public Hospital update();
}
