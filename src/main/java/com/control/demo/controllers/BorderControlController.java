package com.control.demo.controllers;



import com.control.demo.services.BorderControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("borderControl")
public class BorderControlController {
    private final BorderControlService borderControlService;
    private final UpdaterData updaterData;

    @Autowired
    public BorderControlController(BorderControlService borderControlService, UpdaterData updaterData) {
        this.borderControlService = borderControlService;
        this.updaterData = updaterData;
    }

    @PostMapping
    public ResponseEntity<Void> passControll(@RequestParam("id") UUID passangerId) {
        updaterData.updateDB();
        this.borderControlService.checkPassanger(passangerId);
        return ResponseEntity.ok().build();
    }

}
