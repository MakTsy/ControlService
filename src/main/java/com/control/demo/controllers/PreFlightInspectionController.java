package com.control.demo.controllers;

import com.control.demo.services.PreFlightInspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("flightControl")
public class PreFlightInspectionController {
    private final PreFlightInspectionService preFlightInspectionService;
    private final UpdaterData updaterData;

    @Autowired
    public PreFlightInspectionController(PreFlightInspectionService preFlightInspectionService, UpdaterData updaterData) {
        this.preFlightInspectionService = preFlightInspectionService;
        this.updaterData = updaterData;
    }

    @PostMapping
    public ResponseEntity<Void> passControll(@RequestParam("id") UUID passangerId) {
        updaterData.updateDB();
        this.preFlightInspectionService.inspect(passangerId);
        return ResponseEntity.ok().build();
    }
}
