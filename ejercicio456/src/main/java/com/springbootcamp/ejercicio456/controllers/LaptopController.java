package com.springbootcamp.ejercicio456.controllers;

import com.springbootcamp.ejercicio456.entities.Laptop;
import com.springbootcamp.ejercicio456.repositories.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


@RestController
public class LaptopController {

    @Autowired
    LaptopRepository laptopRepository;

    @GetMapping("/")
    public ResponseEntity<List<Laptop>> findAllLaptops() {

        List<Laptop> laptops = laptopRepository.findAll();

        return laptops.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(laptops);
}

    @PostMapping("/")
    public Laptop createLaptop(@RequestBody Laptop laptop) {

        return laptopRepository.save(laptop);
    }


}
