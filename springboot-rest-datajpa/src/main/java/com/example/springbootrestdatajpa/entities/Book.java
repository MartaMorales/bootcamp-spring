package com.example.springbootrestdatajpa.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "BOOKS")
@ApiModel("Entidad libro para representar un elemento didactico compuesto por laminas de celulosa") //Swagger
public class Book {

    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave ficticia autoincrementada tipo Long") //Swagger
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    @ApiModelProperty("Precio en euros con dos decimales utilizando el . como separador") //swagger
    private Double price;
    private LocalDate release;
    private boolean online;

    //Constructores

    public Book() {
    }

    public Book(Long id, String title, String author, Integer pages, Double price, LocalDate release, boolean online) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.release = release;
        this.online = online;
    }

    //Getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

}
