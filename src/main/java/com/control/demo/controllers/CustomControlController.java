package com.control.demo.controllers;

import com.control.demo.services.CustomsControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("customControl")
public class CustomControlController {
    private final CustomsControlService customsControlService;
    private final UpdaterData updaterData;

    @Autowired
    public CustomControlController(CustomsControlService customsControlService, UpdaterData updaterData) {
        this.customsControlService = customsControlService;
        this.updaterData = updaterData;
    }

    @PostMapping("/greenLine")
    public ResponseEntity<Void> passControll(@RequestParam("id") UUID passangerId) {
        updaterData.updateDB();
        this.customsControlService.skipAndCheck(passangerId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/redLine")
    public ResponseEntity<Void> passControll(@RequestParam("id") UUID passangerId, @RequestParam("description") String text) {
        updaterData.updateDB();
        this.customsControlService.declarateAndCheck(passangerId, text);
        return ResponseEntity.ok().build();
    }
}
