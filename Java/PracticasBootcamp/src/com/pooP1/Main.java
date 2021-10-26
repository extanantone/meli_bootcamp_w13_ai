package com.pooP1;

public class Main {

    public static void main(String[] args) {

        Persona vacio = new Persona();
        Persona danuit = new Persona("1067853552","Danuit Petro",34);
        Persona lenys = new Persona("1067897521","Lenys Cuervo",30,78.5,1.68);

        int imc = lenys.calcular();
        boolean esMayorDeEdad = lenys.esMayorDeEdad();
        String nivelDePeso ="";

       if(imc == -1){//Bajo peso
           nivelDePeso = "Bajo peso";
       }else if(imc == 0){//Peso saludable
           nivelDePeso = "Peso saludable";
       }else{//Sobrepeso
           nivelDePeso = "Sobrepeso";
       }

       System.out.println("La "+ lenys.toString()+" Es "+ (esMayorDeEdad?"mayor de edad":"menor de edad")+" y tiene "+nivelDePeso);

    }
}
