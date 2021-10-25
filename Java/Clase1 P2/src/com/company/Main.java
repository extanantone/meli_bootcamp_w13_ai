package com.company;

import java.util.*;

public class Main {
    static List<Persona> inscriptos = new LinkedList<>();

    static String [] circuitos = new String []{
        "chico",
        "mediano",
        "avanzado"
    };

    public static void main(String[] args) {
        //cargarDatos();
        agregarPersona(new Persona(3024312, "Pedro", "Martinez", (short) 29, "352-1523423", "352-1523423", "A+", circuitos[0]));
        agregarPersona(new Persona(3965464, "Gaston", "Alvez", (short) 14, "352-1523423", "352-1523423", "B-", circuitos[1]));
        agregarPersona(new Persona(1854645, "Laura", "Rosales", (short) 45, "352-1523423", "352-1523423", "A-", circuitos[1]));
        agregarPersona(new Persona(3890321, "Martina", "Bogado", (short) 16, "352-1523423", "352-1523423", "AB+", circuitos[2]));

        mostrarInscriptos(circuitos[0]);
        mostrarInscriptos(circuitos[1]);
        mostrarInscriptos(circuitos[2]);

        desinscribirPersona(3965464);
        mostrarInscriptos(circuitos[1]);

    }
/*
    private static void cargarDatos(){
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
*/
    private static void agregarPersona(Persona persona){
        short pago = 0;
        boolean inscribio = true;
        switch(persona.categoria){
            case "chico":{
                if(persona.edad < 18)
                    pago = 1300;
                else
                    pago = 1500;
                break;
            }
            case "mediano":{
                if(persona.edad < 18)
                    pago = 2000;
                else
                    pago = 2300;

                break;
            }
            case "avanzado":{
                if(persona.edad < 18){
                    inscribio = false;
                    System.out.println("No se permiten inscripciones de menores de 18 al circuito avanzado");
                }
                else
                    pago = 2800;
                break;
            }
            default:
                System.out.println("Categoría errónea");

        }
        if (inscribio){
            inscriptos.add(persona);
            System.out.format("Debe pagar %d pesos \n", pago);

        }
    }

    private static void desinscribirPersona(int dni){
        for(Persona p : inscriptos){
            if(p.dni == dni)
                inscriptos.remove(p);
        }
    }

    private static void mostrarInscriptos(String categoria){
        System.out.println("-------Inscriptos categoría " + categoria + " ----------");
        for(Persona p : inscriptos){
            if(p.categoria.equals(categoria))
                System.out.println(p.toString() + " Inscripción: " + inscriptos.indexOf(p));
        }
    }
}
