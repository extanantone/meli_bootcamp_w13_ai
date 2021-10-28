package com.company;

import com.company.objets.Persona;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Persona> circuitoChico = new LinkedList<Persona>();
    public static List<Persona> circuitoMedio = new LinkedList<Persona>();
    public static List<Persona> circuitoAvanzado = new LinkedList<Persona>();

    static HashMap<Integer,Integer> inscripciones = new HashMap<Integer, Integer>();
    static HashMap<Integer,List<Persona>> carreras = new HashMap<Integer, List<Persona>>();





    public static void mostrarInscripcionesYSuValor(){
        inscripciones.forEach((k,v)->{
            if (v == 1){

            }
        });
    }
    
    
    
    public static void agregarPersona(int opcion, Persona p){
        if (opcion == 3){
            if (p.getEdad()>18){
                circuitoAvanzado.add(p);
                inscripciones.put(p.getDni(),opcion);
            }
        }else {
            inscripciones.put(p.getDni(),opcion);
            if (opcion == 1) {
                circuitoChico.add(p);
            } else {
                circuitoMedio.add(p);
            }
        }
    }
    public static void mostrarParticipantes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la categoria que desea mostrar");
        // entrada de una cadena
        int categoria = sc.nextInt();
        int i = 1;
        if (categoria == 1){
            for(Persona p :circuitoChico) {
                i++;
                System.out.println("Maratonista"+p.getNombre() +" "+p.getApellido() + ", numero de inscripcion:"+i);
            }
        } else {
            if (categoria == 2){
                for(Persona p :circuitoMedio) {
                    i++;
                    System.out.println("Maratonista"+p.getNombre() +" "+p.getApellido() + ", numero de inscripcion:"+(circuitoChico.size()+i));
                }
            } else {
                for(Persona p :circuitoAvanzado) {
                    i++;
                    System.out.println("Maratonista"+p.getNombre() +" "+p.getApellido() + ", numero de inscripcion:"+(circuitoChico.size()+circuitoMedio.size()+i));
                }
            }
        }
    }

    public static void inscribirParticipante(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el dni, edad, nombre y apellido en este orden");
        // entrada de una cadena
        int edad = sc.nextInt();
        int dni = sc.nextInt();
        String nombre = sc.nextLine();
        String apellido = sc.nextLine();

        System.out.println("A que carrera desea inscribirle (ingrese una opcion): 1. Circuito chico - 2. Circuito medio - 3. Circuito avanzado (>18)");
        int opcion = sc.nextInt();

        Persona p = new Persona(edad,dni,nombre,apellido);
        agregarPersona(opcion,p);
    }

    public static void desincribirParticipante(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la categoria, o ingrese 0 si desea que lo busquemos nosotros.");
        int categoria = sc.nextInt();

        // entrada de una cadena
    }

    public static void main(String[] args) {

        Persona persona = new Persona(40348156,19,"Luis","Gomez Morales");

        int opcion = 3;
        agregarPersona(opcion,persona);


        //punto a (Funca)
        //inscribirParticipante();
        //inscribirParticipante();
        //nscribirParticipante();

        //punto b (Funca)
        mostrarParticipantes();

        //punto c
        //desincribirParticipante();
        System.out.println("Se buscara");
        //System.out.println(circuitoAvanzado.toString());
        //System.out.println(inscripciones.toString());

        //punto d
        mostrarInscripcionesYSuValor();
    }


}
