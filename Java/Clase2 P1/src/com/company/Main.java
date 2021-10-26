package com.company;

public class Main {

    public static void main(String[] args) {
        Persona perVacia = new Persona();
        Persona perBasica = new Persona("35738012", "Damian", (short)35);
        Persona perCompleta = new Persona("2582192", "Laura", (short)44, 56, (float) 1.65);

        short imc = perCompleta.calcularIMC();
        if(imc == -1)
            System.out.println("Posee un índice de masa corporal demasiado bajo. Está bajo de peso");
        else if(imc == 0)
            System.out.println("Posee un índice de masa corporal correcto. Su peso es saludable");
        else
            System.out.println("Posee un índice de masa corporal demasiado alto. Presenta sobrepeso");

    }
}
