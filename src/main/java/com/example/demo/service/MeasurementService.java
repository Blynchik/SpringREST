package com.example.demo.service;

import com.example.demo.models.Measurement;
import com.example.demo.models.Sensor;
import com.example.demo.repository.MeasurementRepository;
import com.example.demo.util.measurementUtil.MeasurementNotFoundException;
import com.example.demo.util.sensorUtil.SensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    public Measurement findOne(int id) {
        Optional<Measurement> foundMeasurement = measurementRepository.findById(id);
        return foundMeasurement.orElseThrow(MeasurementNotFoundException::new);
    }

    public Optional<List<Measurement>> findByOwnerName(String name) {
        Optional<List<Measurement>> foundMeasurements = measurementRepository.findBySensorName(name);
        return Optional.ofNullable(foundMeasurements.orElseThrow(SensorNotFoundException::new));
    }

    @Transactional(readOnly = false)
    public void save(Measurement measurement) {
        measurementRepository.save(measurement);
    }
}
