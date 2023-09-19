package com.ea.coding.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EARepositoryTest {

    @InjectMocks
    private EARepository eaRepository;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFetchData(){
        String url = "test";
        String responseJson = "{ \"name\": \"Festival\", \"bands\":[{ \"name\":\"Band\",\"recordLabel\":\"label\" }] }";
        ResponseEntity<String> responseEntity = new ResponseEntity<>(responseJson, HttpStatus.OK);
        when(restTemplate.getForEntity("test", String.class)).thenReturn(responseEntity);

        //act
        ResponseEntity<String> response = eaRepository.fetchMusicFestivals("test");

        //assert
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

}
