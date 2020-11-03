package com.control.demo.controllers;

import com.control.demo.entities.Passenger;
import com.control.demo.repo.PassengerRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
public class UpdaterData {
    private final PassengerRepository passengerRepository;
    private static final String URL = "http://localhost:8085";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    @Autowired
    public UpdaterData(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Transactional
    public void updateDB() {
        ResponseEntity<String> response = restTemplate.getForEntity(URL + "/getPassengers", String.class);
        JsonArray flightDTOs = gson.fromJson(response.getBody(), JsonArray.class);
        for (JsonElement fl : flightDTOs) {
            Passenger flightDTO = gson.fromJson(fl, Passenger.class);
            this.passengerRepository.save(flightDTO);
        }
    }


}
