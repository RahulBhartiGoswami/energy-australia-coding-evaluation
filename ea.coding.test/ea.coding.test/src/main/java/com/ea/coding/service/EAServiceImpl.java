package com.ea.coding.service;

import com.ea.coding.model.Band;
import com.ea.coding.model.MusicFestival;
import com.ea.coding.repository.EARepository;
import com.ea.coding.util.EAUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * Service class containing the business logic
 */
@Service
public class EAServiceImpl implements EAService {

    @Autowired
    private EARepository eaRepository;

    private static final Logger logger = LoggerFactory.getLogger(EAServiceImpl.class);
    /**
     * This method is designed to call the repository layer to get the data from the respository
     * layer which internally calling the external API
     *
     * @param url
     * @return String
     */
    public String fetchFestivals(String url) {
        logger.info("entering fetchFestivals() method");
        ResponseEntity<String> festivalResponse = eaRepository.fetchMusicFestivals(url);
        logger.info("exiting fetchFestivals() method");
        return sortFestivals(festivalResponse.getBody());
    }

    /**
     * This method is used to sort the festivals
     *
     * @param festivalData
     * @return sorted String
     */
    private String sortFestivals(String festivalData) {
        logger.info("entering sortFestivals() method");
        // parse the json to the Desired POJO
        List<MusicFestival> festivals = EAUtility.parseJsonToFestivals(festivalData);

        // taking the TreeMap collection to sort the record based on the key
        Map<String, Map<String, List<String>>> formattedData = new TreeMap<>();

        // iterate the festivals
        for (MusicFestival festival : festivals) {
            String festivalName = festival.getName();
            for (Band band : festival.getBands()) {
                String recordLabel = band.getRecordLabel();
                String bandName = band.getName();
                if (recordLabel != null) {
                    formattedData.putIfAbsent(recordLabel, new TreeMap<>());
                    formattedData.get(recordLabel).putIfAbsent(bandName, new ArrayList<>());
                    formattedData.get(recordLabel).get(bandName).add(festivalName);
                }
            }
        }

        StringBuilder formattedResult = new StringBuilder();
        // This loop is used to iterate and process the record and bands
        for (Map.Entry<String, Map<String, List<String>>> recordLabelEntry : formattedData.entrySet()) {
            String recordLabel = recordLabelEntry.getKey();
            formattedResult.append(recordLabel).append("\n");
            Map<String, List<String>> bandAndFestival = recordLabelEntry.getValue();

            // get the band and check if it has got the festivals entry associated with it.
            for (Map.Entry<String, List<String>> bandEntry : bandAndFestival.entrySet()) {
                String bandName = bandEntry.getKey();
                List<String> festivalIsAttended = bandEntry.getValue();
                formattedResult.append(" ").append(bandName).append("\n");
                for (String festival : festivalIsAttended) {
                    formattedResult.append(" ").append(festival).append("\n");
                }
            }
        }
        logger.info("exiting sortFestivals() method");
        return formattedResult.toString();
    }

}

