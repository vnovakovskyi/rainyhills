package com.test.rainyhills.controller;

import com.test.rainyhills.service.WaterValueCounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RainyHillsController {

    final WaterValueCounterService waterValueCounterService;

    public RainyHillsController(WaterValueCounterService waterValueCounterService) {
        this.waterValueCounterService = waterValueCounterService;
    }

    @GetMapping("/watervalue/{surface}")
    public int calculateWaterValue(@PathVariable int[] surface) {
        return waterValueCounterService.count(surface);
    }
}
