package com.example.bootcampspring.spring_beans;

import com.example.bootcampspring.introduccion_a_spring.main.calculator.Calculadora;
import org.springframework.stereotype.Component;

@Component
public class GestorFacturas {

    public Calculadora calculadora;

    public GestorFacturas( Calculadora calculadora) {
        System.out.println("Ejecutando constructor GestorFacturas");
    this.calculadora = calculadora;
    }
}
