package com.example.demo.util.measurementUtil;

import com.example.demo.models.Measurement;

public class MeasurementNotCreatedException extends RuntimeException{

    public MeasurementNotCreatedException(String msg){
        super(msg);
    }
}
