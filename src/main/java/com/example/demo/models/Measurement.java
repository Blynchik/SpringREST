package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.Date;
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
    private Sensor sensor;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Measurement(){
    }

    public Measurement(double value, boolean raining, Sensor sensor){
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
        this.createdAt = Date.from(Instant.now());
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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return id == that.id && Double.compare(that.value, value) == 0 && raining == that.raining && createdAt == that.createdAt && sensor.equals(that.sensor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, raining, sensor, createdAt);
    }
}
