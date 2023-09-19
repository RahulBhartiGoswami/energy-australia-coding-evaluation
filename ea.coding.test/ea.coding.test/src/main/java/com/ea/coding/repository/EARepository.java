package com.ea.coding.repository;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface EARepository {

    public ResponseEntity<String> fetchMusicFestivals(String url);

}
