package com.example.demo.service;

import com.example.demo.models.Sensor;
import com.example.demo.repository.SensorRepository;
import com.example.demo.util.SensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    public Sensor findOne(int id) {
        Optional<Sensor> foundSensor = sensorRepository.findById(id);
        return foundSensor.orElseThrow(SensorNotFoundException::new);
    }

    public Sensor findByName(String name) {
        Optional<Sensor> foundSensor = sensorRepository.findByName(name);
        return  foundSensor.orElseThrow(SensorNotFoundException::new);
    }

    @Transactional(readOnly = false)
    public void save(Sensor sensor) {
        sensorRepository.save(sensor);
    }
}
