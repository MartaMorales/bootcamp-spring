package com.example.springdata;

import javax.persistence.*;

@Entity
public class Coche {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer anio;
    private String marca;
    private String modelo;

    //constructores

    public Coche() {
    }

    public Coche(Integer id, Integer year, String manufacturer, String model) {
        this.id = id;
        this.anio = year;
        this.marca = manufacturer;
        this.modelo = model;
    }


    //getter y setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    //toString
    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", anio=" + anio +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
