package com.example.demo.controller;

import com.example.demo.models.Sensor;
import com.example.demo.service.SensorService;
import com.example.demo.util.SensorErrorResponse;
import com.example.demo.util.SensorNotCreatedException;
import com.example.demo.util.SensorNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> create (@RequestBody @Valid Sensor sensor,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new SensorNotCreatedException(errorMsg.toString());
        }

        sensorService.save(sensor);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<SensorErrorResponse> handleException(SensorNotFoundException e) {
        SensorErrorResponse response = new SensorErrorResponse(
                "Sensor with this id wasn't found:",
                System.currentTimeMillis()
        );
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity <SensorErrorResponse> handleException(SensorNotCreatedException e){
        SensorErrorResponse response = new SensorErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
