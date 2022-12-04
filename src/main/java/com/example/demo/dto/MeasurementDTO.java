package com.example.demo.dto;

import com.example.demo.models.Sensor;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class MeasurementDTO {

    @Column(name = "value")
    @NotEmpty(message = "Value should not be empty")
    @Min(value = -100, message = "Temperature should be higher than -100")
    @Max(value = 100, message = "Temperature should be lower than 100")
    private double value;

    @Column(name = "raining")
    @NotEmpty(message = "Condition should not be empty")
    private boolean raining;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    @NotEmpty(message = "Sensor should not be empty")
    private Sensor owner;

    public MeasurementDTO(){
    }

    public MeasurementDTO(double value, boolean raining, Sensor owner){
        this.value = value;
        this.raining = raining;
        this.owner = owner;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getOwner() {
        return owner;
    }

    public void setOwner(Sensor owner) {
        this.owner = owner;
    }
}
