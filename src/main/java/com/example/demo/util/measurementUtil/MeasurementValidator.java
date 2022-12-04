package com.example.demo.util.measurementUtil;

import com.example.demo.dto.MeasurementDTO;
import com.example.demo.dto.SensorDTO;
import com.example.demo.models.Measurement;
import com.example.demo.models.Sensor;
import com.example.demo.service.MeasurementService;
import com.example.demo.service.SensorService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidator implements Validator {

    private final MeasurementService measurementService;
    private final SensorService sensorService;

    @Autowired
    public MeasurementValidator(MeasurementService measurementService, SensorService sensorService) {
        this.measurementService = measurementService;
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MeasurementDTO measurementDTO = (MeasurementDTO) target;

        if (sensorService.findByName(measurementDTO.getOwner().getName()).isPresent()) {
            errors.rejectValue("sensor", "", "This sensor does not exist");
        }
    }
}
