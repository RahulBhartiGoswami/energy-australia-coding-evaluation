package com.ea.coding.controller;


import com.ea.coding.service.EAService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ea")
public class EnerygyAustraliaMusicFestivalController {

    @Value("${ea-api-url}")
    private String url;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private EAService eaService;

    private static final Logger logger = LoggerFactory.getLogger(EnerygyAustraliaMusicFestivalController.class);

    @GetMapping("/api/v1/festivals")
    public ResponseEntity<String> fetchMusicFestivals(){
        logger.info("entering fetchMusicFestivals");
        String sortedFestivalResponse = eaService.fetchFestivals(url);
        HttpHeaders httpHeaders = new HttpHeaders();
        // set the content type as application_json
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (sortedFestivalResponse==null || sortedFestivalResponse.isEmpty()){
            // setting the response to "Data not found, try again after sometimes."
            // if the API doesn't send any data
            return new ResponseEntity<>("Data not found, try again after sometimes.",httpHeaders, HttpStatus.OK);
        }
        logger.info("exiting fetchMusicFestivals");
        return new ResponseEntity<>(sortedFestivalResponse,httpHeaders, HttpStatus.OK);
    }

}
