package com.medhead.emergencydispatcher.infrastructure;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.medhead.emergencydispatcher.application.DistanceMatrixApi.DistanceMatrixServiceImpl;
import com.medhead.emergencydispatcher.infrastructure.rest.EmergencyDispatcherController;

@WebMvcTest(controllers = EmergencyDispatcherController.class)
public class EmergencyDispatcherControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DistanceMatrixServiceImpl distanceMatrixService;

    @Test
    public void testFindNearest() throws Exception {
        String requestBody = "{\"lat\":\"51.37\",\"lng\":\"-0.4060\",\"speciality\":\"4545jhvrezr\"}";
        mockMvc.perform(post("/findNearest&apikey=my-securekey-msed")
            .content(requestBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
}
