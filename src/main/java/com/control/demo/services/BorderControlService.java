package com.control.demo.services;

import com.control.demo.entities.Passenger;
import com.control.demo.repo.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class BorderControlService {
    private final PassengerRepository passengerRepository;

    @Autowired
    public BorderControlService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Transactional
    public void checkPassanger(UUID id) {
       Passenger passenger  = this.passengerRepository.findById(id).orElseThrow();
       passenger.setPassportControlCheck("Passed");
       this.passengerRepository.save(passenger);
    }
}
