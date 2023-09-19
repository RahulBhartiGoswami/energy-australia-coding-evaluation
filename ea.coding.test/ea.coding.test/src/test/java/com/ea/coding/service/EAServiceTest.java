package com.ea.coding.service;

import com.ea.coding.repository.EARepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EAServiceTest {

    @InjectMocks
    private EAService eaService;
    @Mock
    private EARepository eaRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void fetchFestivals(){
        String responseJson = "{ \"name\": \"Festival\", \"bands\":[{ \"name\":\"Band\",\"recordLabel\":\"label\" }] }";
        when(eaRepository.fetchMusicFestivals(Mockito.anyString()))
                .thenReturn(mockFetchMusicFestivals());
        String response = eaService.fetchFestivals(Mockito.anyString());
        assertEquals(mockFetchMusicFestivals().getBody(),response);

    }

    public static ResponseEntity<String> mockFetchMusicFestivals(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String responseJson = "{ \"name\": \"Festival\", \"bands\":[{ \"name\":\"Band\",\"recordLabel\":\"label\" }] }";
        return new ResponseEntity<>(responseJson,httpHeaders, HttpStatus.OK);
    }



}
