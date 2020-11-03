package com.control.demo.services;


import com.control.demo.entities.Passenger;
import com.control.demo.repo.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class CustomsControlService {
    private final PassengerRepository passengerRepository;

    @Autowired
    public CustomsControlService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Transactional
    public String declarateAndCheck(UUID id, String description) {
        Passenger passenger  = this.passengerRepository.findById(id).orElseThrow();
        passenger.setCustomsControlCheck("Passed");
        this.passengerRepository.save(passenger);
        return "Passanger: " + id + " you have successfully declarated " + description;
    }

    @Transactional
    public String skipAndCheck(UUID id) {
        Passenger passenger  = this.passengerRepository.findById(id).orElseThrow();
        passenger.setCustomsControlCheck("Passed");
        this.passengerRepository.save(passenger);
        return "Passanger: " + id + " you have successfully passed custom control without declaration";
    }

}
