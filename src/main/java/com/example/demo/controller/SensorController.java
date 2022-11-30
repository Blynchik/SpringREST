package com.example.demo.controller;

import com.example.demo.models.Sensor;
import com.example.demo.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Sensor getSensor (@PathVariable("id") int id){
        return sensorService.findOne(id);
    }
}
