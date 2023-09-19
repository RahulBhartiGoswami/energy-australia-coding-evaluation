package com.ea.coding.controller;


import com.ea.coding.service.EAService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class EnerygyAustraliaMusicFestivalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EAService eaService;

    @Value("${ea-api-url}")
    private String eaApiUrl;

    @BeforeEach
    public void setUp() {
         }

    @Test
    public void testFetchMusicFestivals_EmptyResponse() throws Exception {
        String responseJson = "{ \"name\": \"Festival\", \"bands\":[{ \"name\":\"Band\",\"recordLabel\":\"label\" }] }";
        when(eaService.fetchFestivals(eaApiUrl)).thenReturn("");
        mockMvc.perform(MockMvcRequestBuilders.get("/ea/api/v1/festivals"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string("Data not found, try again after sometimes."));
    }

    @Test
    public void testFetchMusicFestivals() throws Exception {

        String responseJson = "{ \"name\": \"Festival\", \"bands\":[{ \"name\":\"Band\",\"recordLabel\":\"label\" }] }";
        when(eaService.fetchFestivals(eaApiUrl)).thenReturn(responseJson);
        mockMvc.perform(MockMvcRequestBuilders.get("/ea/api/v1/festivals"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(responseJson));

    }


}
