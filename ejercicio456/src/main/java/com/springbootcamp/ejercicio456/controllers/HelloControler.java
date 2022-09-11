package com.springbootcamp.ejercicio456.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @GetMapping("/saludo")
    public String saludar(){
        return "Hola Mundo";
    }



}
