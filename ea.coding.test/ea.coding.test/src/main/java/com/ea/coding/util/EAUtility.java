package com.ea.coding.util;

import com.ea.coding.model.MusicFestival;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.List;

/**
 * Utility class of the EA application
 */
public class EAUtility {

    /**
     * Utility method to parse the json to the desired POJO
     * @param json
     * @return List<MusicFestival>
     */
    public static List<MusicFestival> parseJsonToFestivals(String json){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<MusicFestival>> typeReference = new TypeReference<List<MusicFestival>>(){};
            return objectMapper.readValue(json,typeReference);
        } catch (Exception e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
