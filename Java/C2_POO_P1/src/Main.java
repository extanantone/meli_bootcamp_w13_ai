/*
 * Copyright (c) 2021. Created by David Orejuela
 */

import java.util.HashMap;

public class Main
{
    public static void main(String[] args)
    {
        int IMC;
        String tipoEdad, IMCResult;

        HashMap<Integer, String> tablaIMC = new HashMap<>();
        tablaIMC.put(1, "Sobrepeso");
        tablaIMC.put(0, "Peso saludable");
        tablaIMC.put(-1, "Bajo peso");

        Persona sinDatos = new Persona();
        Persona nombreCompleto = new Persona("Javier Jerez", (byte) 25, "11i29222");
        Persona datosCompletos= new Persona("Maria Trujillo", (byte) 21, "9282222", 78, 1.82f);
        IMC = datosCompletos.calcularIMC();

        tipoEdad = datosCompletos.esMayorDeEdad() ? "Mayor" : "Menor";
        System.out.println("Datos de la persona");
        System.out.println(datosCompletos);
        System.out.printf("%s es %s de edad\n", datosCompletos.nombre, tipoEdad);
        System.out.printf("Su nivel de peso de acuerdo a la masa corporal es %s\n", tablaIMC.get(IMC));

    }
}
