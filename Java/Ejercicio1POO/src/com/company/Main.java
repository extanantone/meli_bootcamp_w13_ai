package com.company;

public class Main {

    public static void main(String[] args) {
	    // Declaracion de objetos
        Persona vacio = new Persona();
        Persona mitad = new Persona("Juan",25,"123456");
        Persona completo = new Persona("Pepe",26,"654321",69.50,1.70);

        int imc = completo.calcularIMC();
        boolean mayorEdad= completo.esMayordeEdad();
        String peso ="";

        if (imc == -1){
            peso="bajo peso";
        }else if (imc == 0){
            peso="saludable";
        }else {
            peso="Sobre peso";
        }

        System.out.println("La "+completo.toString()+" es "+(mayorEdad?"mayor de edad":"menor de edad")+" y tiene un estado "+peso);
    }
}
