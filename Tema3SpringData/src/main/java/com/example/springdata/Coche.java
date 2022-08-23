package com.example.springdata;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coche {

    //atributos
    @Id
    private Long id;
    private Integer year;
    private String manufacturer;
    private String model;

    //constructores

    public Coche() {
    }

    public Coche(Long id, Integer year, String manufacturer, String model) {
        this.id = id;
        this.year = year;
        this.manufacturer = manufacturer;
        this.model = model;
    }


    //getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", year=" + year +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
