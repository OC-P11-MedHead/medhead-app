package com.medhead.emergencymanagement.infrastructure.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(controllers = EmergencyController.class)
public class EmergencyControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetEmergencies() throws Exception {
        mockMvc.perform(get("/emergencies"))
            .andExpect(status().isOk());
    }

    @Test
    public void testCreateEmergency() throws Exception {
        String requestBody = "{\"hospitalUuid\":\"17970\",\"hospitalName\":\"Walton\",\"speciality\":\"4545jhvrezr\",\"origin\":\"test\"}";
        mockMvc.perform(post("/emergency")
            .content(requestBody))
            .andExpect(status().isCreated());
    }
}
