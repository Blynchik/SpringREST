package com.example.demo.repository;

import com.example.demo.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    Optional<List<Measurement>> findBySensorName(String name);
    List<Measurement> findByRaining(boolean raining);
}
