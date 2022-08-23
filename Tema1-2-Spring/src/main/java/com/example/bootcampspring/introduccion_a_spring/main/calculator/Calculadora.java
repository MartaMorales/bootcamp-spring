package com.example.bootcampspring.introduccion_a_spring.main.calculator;

import org.springframework.stereotype.Component;

@Component //esto es una anotacion que indica a Spring que es un bean
public class Calculadora {

    public Calculadora(){
        System.out.println("Ejecutando constructor Calculadora");
    }


    public String saludar(){
        return "Hola Mundo";
    }
}
