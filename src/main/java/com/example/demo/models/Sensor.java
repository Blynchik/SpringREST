package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "Sensor")
public class Sensor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "rain")
    private boolean isRainy;

    @Column(name = "temperature")
    private double temperature;

    public Sensor(){
    }

    public Sensor(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRainy() {
        return isRainy;
    }

    public void setRainy(boolean rainy) {
        isRainy = rainy;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return id == sensor.id && Objects.equals(name, sensor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
