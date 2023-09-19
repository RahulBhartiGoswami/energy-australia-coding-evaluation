package com.ea.coding.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class EARepositoryImpl implements EARepository {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(EARepositoryImpl.class);

    public ResponseEntity<String> fetchMusicFestivals(String url) {
        logger.info("entering fetchMusicFestivals() method");
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        logger.info("exiting fetchMusicFestivals() method with the response :{} ", response);
        return response;
    }

}
