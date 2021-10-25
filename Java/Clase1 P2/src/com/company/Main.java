package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    List<Persona> inscriptos = new ArrayList<Persona>();

    public static void main(String[] args) {
        cargarDatos();
        

    }

    private void cargarDatos(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Agregue los siguiente datos presionando 'enter' al termino del ingreso de cada uno (dni, nombre, apellido, edad, celular, nroEmergencia, grupoSanguineo)");
        int dni = sc.nextInt();
        String nombre = sc.next();
        String apellido = sc.next();
        short edad = sc.nextShort();
        String celular = sc.next();
        String nroEmergencia = sc.next();
        String grupoSanguineo = sc.next();

        System.out.println("Ingrese la categoría que desea competir (chico/medio/avanzado)");
        String cat = sc.next();
        Persona per = new Persona(dni, nombre, apellido, edad, celular, nroEmergencia, grupoSanguineo, cat);



    }
}
