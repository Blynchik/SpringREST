package com.example.demo.service;

import com.example.demo.models.Measurement;
import com.example.demo.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorService sensorService;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }


    public Integer rainyDaysCount() {
        return measurementRepository.findByRaining(true).size();
    }

    @Transactional(readOnly = false)
    public void save(Measurement measurement) {
        enrich(measurement);
        measurementRepository.save(measurement);
    }

    private void enrich(Measurement measurement){
        measurement.setSensor(sensorService.findByName(measurement.getSensor().getName()).get());
        measurement.setCreatedAt(Date.from(Instant.now()));
    }
}
