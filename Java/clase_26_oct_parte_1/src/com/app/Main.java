package com.app;

public class Main {

    public static void main(String[] args) {
        Persona juan = new Persona();
        Persona jorge = new Persona("Jorge", 13, "1220009");
        Persona luis = new Persona("Luis",20,"222222",1.7,70);
        System.out.println();
        int indiceMasa = luis.calcularIMC();
        String ms;
        if(indiceMasa==-1) ms="Bajo peso";
        else if(indiceMasa==0) ms="Peso saludable";
        else ms="Sobrepeso";
        System.out.println("Indice de masa: "+ms);
        System.out.println("Es mayor de edad: "+luis.esMayorDeEdad());
        System.out.println(luis.toString());
        System.out.println();

    }


    
}
