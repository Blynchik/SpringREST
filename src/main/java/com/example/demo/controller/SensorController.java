package com.example.demo.controller;

import com.example.demo.models.Sensor;
import com.example.demo.service.SensorService;
import com.example.demo.util.SensorErrorResponse;
import com.example.demo.util.SensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping()
    public List<Sensor> getSensors() {
        return sensorService.findAll();
    }

    @GetMapping("/{id}")
    public Sensor getSensor(@PathVariable("id") int id) {
        return sensorService.findOne(id);
    }

    @ExceptionHandler
    private ResponseEntity<SensorErrorResponse> handleException(SensorNotFoundException e) {
        SensorErrorResponse response = new SensorErrorResponse(
                "Sensor with this id wasn't found:",
                System.currentTimeMillis()
        );
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
