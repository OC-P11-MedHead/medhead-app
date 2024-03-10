package com.medhead.mshospitalmanagement.infrastructure.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.medhead.mshospitalmanagement.application.emergency.EmergencyService;
import com.medhead.mshospitalmanagement.application.hospital.HospitalServiceImpl;
import com.medhead.mshospitalmanagement.application.speciality.SpecialityServiceImpl;

@WebMvcTest(controllers = HospitalController.class)
public class HospitalControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HospitalServiceImpl hospitalService;

    @MockBean
    private SpecialityServiceImpl specialityService;

    @MockBean
    private EmergencyService emergencyService;   

    @Test
    public void testGetHospitals() throws Exception {
        mockMvc.perform(get("/hospitals"))
            .andExpect(status().isOk());
    }

    @Test
    public void testGetSpecialities() throws Exception {
        mockMvc.perform(get("/specialities"))
            .andExpect(status().isOk());
    }

    @Test
    public void testFindHospitalBySpeciality() throws Exception {
        // Hospitals with cardiology speciality
        mockMvc.perform(get("/hospitals/speciality/id=4545jhvrezr"))
        .andExpect(status().isOk());
    }

    @Test
    public void testBookBed() throws Exception {
        mockMvc.perform(get("/hospitals/id=17970/bookbed/speciality=4545jhvrezr"))
        .andExpect(status().isOk());
    }
}
