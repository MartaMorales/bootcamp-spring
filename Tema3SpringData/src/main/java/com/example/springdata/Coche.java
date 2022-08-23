package com.example.springdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coche {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identifier;
    private Integer year;
    private String manufacturer;
    private String model;

    //constructores

    public Coche() {
    }

    public Coche(Integer id, Integer year, String manufacturer, String model) {
        this.identifier = id;
        this.year = year;
        this.manufacturer = manufacturer;
        this.model = model;
    }


    //getter y setter

    public Integer getId() {
        return identifier;
    }

    public void setId(Integer id) {
        this.identifier = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    //toString
    @Override
    public String toString() {
        return "Coche{" +
                "id=" + identifier +
                ", year=" + year +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
