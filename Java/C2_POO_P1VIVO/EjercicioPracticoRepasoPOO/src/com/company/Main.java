package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Persona personaSinDatos = new Persona();

        Persona personaMitadDatos = new Persona("Luis",23,"40348156");

        Persona personaTodosDatos = new Persona("Luis",23,"40348156",120.50,1.85);

        //Persona personaMitadsDatos = new Persona("Luis",23); No se puede
        HashMap<Integer,String> resultadoIMC = new HashMap<>();
        resultadoIMC.put(-1,"bajo peso");
        resultadoIMC.put(0,"peso saludable");
        resultadoIMC.put(1,"sobrepeso");
        System.out.println("Hola "+personaTodosDatos.nombre+" usted es"+(personaTodosDatos.esMayorEdad()?" mayor ":" menor ")+"de edad y teniendo en cuenta su IMC, usted tiene "+resultadoIMC.get(personaTodosDatos.calcularIMC()));
    }
}
