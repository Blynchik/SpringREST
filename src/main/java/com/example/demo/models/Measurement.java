package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

@Entity
@Table (name = "Measurement")
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    public Measurement(){
    }

    public Measurement(double value, boolean raining, Sensor owner){
        this.value = value;
        this.raining = raining;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return id == that.id && Double.compare(that.value, value) == 0 && raining == that.raining && Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, raining, owner);
    }
}
