package com.example.bootcampspring;

import com.example.bootcampspring.introduccion_a_spring.main.calculator.Calculadora;
import com.example.bootcampspring.spring_beans.GestorFacturas;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        //TEMA1
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //Opcion1. Crear un objeto de forma normal
        //Calculadora calculatorService = new Calculadora();


        // Opcion 2. Recibir un objeto del contenedor de spring
        Calculadora calculadora = (Calculadora) context.getBean("calculadora");

        System.out.println(calculadora.saludar());


        //Calculadora solo se crea una vez en el contexto de Spring
//        Calculadora calculadora2 = (Calculadora) context.getBean("calculadora");
//
//        System.out.println(calculadora2.saludar());

        //TEMA2
        //Cargar un bean dentro de otro bean
        GestorFacturas gestorFacturas = (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gestorFacturas.calculadora.saludar());
    }
}
