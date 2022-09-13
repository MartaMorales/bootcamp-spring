package com.springbootcamp.ejercicio456.controllers;

import com.springbootcamp.ejercicio456.entities.Laptop;
import com.springbootcamp.ejercicio456.repositories.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
public class LaptopController {

    @Autowired
    LaptopRepository laptopRepository;

    @GetMapping("/laptops")
    public ResponseEntity<List<Laptop>> findAll() {

        List<Laptop> laptops = laptopRepository.findAll();

        return laptops.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(laptops);
}

    @GetMapping("/laptops/{id}")
    public ResponseEntity<Laptop> findById(@RequestParam Long id){
        Optional<Laptop> laptop = laptopRepository.findById(id);
        if(laptop.isPresent() && !laptop.isEmpty()){
            return ResponseEntity.ok(laptop.get());

        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {
        if(Objects.isNull(laptop.getId())) {
            return ResponseEntity.ok(laptopRepository.save(laptop));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(Objects.isNull(laptop.getId())){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(laptopRepository.save(laptop));
    }

    @DeleteMapping("/laptops")
    public ResponseEntity<Laptop> delete(@RequestParam Laptop laptop){
    if(Objects.nonNull(laptop.getId())){
        laptopRepository.delete(laptop);
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/laptops/all")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        if(Objects.isNull(laptopRepository.findAll())) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }


}
