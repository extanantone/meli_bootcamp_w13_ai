package com.company;

public class Main {

    public static void main(String[] args){

        Persona sebastian = new Persona();
        Persona seba = new Persona("Sebastian", 123, "321");
        Persona seb = new Persona("Sebastian", 123, "321", 99, 1.80);
        // Persona fail = new Persona("Pizza", 99); Esto genera error, "No suitable constructor".

        int imc = seb.calcularIMC();

        System.out.println(seb.toString());
        if(imc == -1){
            System.out.println("Tiene un IMC bajo.");
        } else{
            if(imc == 0) {
                System.out.println("Tiene un IMC normal.");
            } else{
                System.out.println("Tiene un IMC alto.");
            }
        }
        if(seb.esMayorDeEdad()){
            System.out.println("Es mayor de edad.");
        } else{
            System.out.println("No es mayor de edad.");
        }
    }
}
