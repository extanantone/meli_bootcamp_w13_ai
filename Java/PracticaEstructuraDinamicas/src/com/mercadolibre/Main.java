package com.mercadolibre;

import com.mercadolibre.dominio.Persona;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        String[]categoriasDefault = {"Circuito Chico","Circuito Medio","Circuito Avanzado"};
        List<String> categoria = new ArrayList<>(Arrays.asList(categoriasDefault));
        Map<Integer,Persona> inscripciones = new HashMap<>();
        boolean salir = false;
        do{
            int cantInscriptos = inscripciones.size() + 1; //Solo sumo 1 para que arranque las inscripciones con 1
            System.out.println("cant inscriptos: " + cantInscriptos);
            mostrarMenuOpciones();
            Scanner input = new Scanner(System.in);
            System.out.println("Ingrese una opcion: ");
            int option = input.nextInt();
            switch (option){
                case 1:
                    Persona persona = new Persona();
                    Persona personaInscripta= incribirPersona(persona,categoria);
                    inscripciones.put(cantInscriptos,personaInscripta); //Aca ya tengo el numero que le voy a asignar al participante y los datos del mismo
                    break;
                case 2:
                    mostrarIncriptos(inscripciones);
                    break;
                case 3:
                    //TODO crear metodo desinscribir participante, puedo buscarlo por el numero o dni y removerlo de mi hash
                    break;
                case 4:
                    //TODO en base a la edad del participante y la categoria en la que se inscriba mostrar monto a abonar
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("La opcion ingresada es incorrecta");
            }
        } while(!salir);
    }

    /* Metodo: mostrarIncriptos
       Parametros: Map<Integer, Persona> inscripciones (hash precargado con las personas inscriptas)
       Tipo: void (no retorna nada)
       funcion: Voy a mostrar todas las personas inscriptas al maraton
     */
    private static void mostrarIncriptos(Map<Integer, Persona> inscripciones) {
        //No lo vimos en clase pero asi se itera un hashMap (expresion lambda, k hace referencia a la clave y v al valor, con el foreach puedo recorrer el hash completo)
        inscripciones.forEach((k,v)-> System.out.println("Numero de inscripcion: " + k + v));
    }

    private static Persona incribirPersona(Persona persona,List<String>categorias) {
        System.out.println("Ingrese el numero de la categoria en la que se va a inscribir: ");
        mostrarCategorias(categorias);
        Scanner input = new Scanner(System.in);
        Scanner inputDatos = new Scanner(System.in);
        Scanner inputNumeros= new Scanner(System.in);
        int numCategoria = input.nextInt();
        if(numCategoria<=0 || numCategoria>categorias.size()){
            System.out.println("El numero ingresado no pertenece a ninguna categoria");
        } else {
            String categoria = categorias.get(numCategoria - 1);
            //persona.setCategoria(categorias.get(numCategoria - 1));
            System.out.println("Ingrese el nombre: ");
            String nombre = inputDatos.nextLine();
            System.out.println("Ingrese el apellido: ");
            String apellido = inputDatos.nextLine();
            System.out.println("Ingrese la edad de la persona: ");
            int edad = input.nextInt();
            System.out.println("Ingrese el grupo sanguineo: ");
            String grupoSanguineo = inputDatos.nextLine();
            System.out.println("Ingrese el dni de la persona: ");
            int dni = input.nextInt();
            System.out.println("Ingrese un numero de emergencia: ");
            double numeroEmergencia = inputNumeros.nextDouble();
            persona = new Persona(nombre,apellido,dni,edad,numeroEmergencia,grupoSanguineo,categoria);
        }
        return persona;
    }

    private static void mostrarCategorias(List<String> listaCategorias) {
        int i=1;
        for (String categoria:listaCategorias) {
            System.out.println( i + " - " +categoria);
            i++;
        }
    }

    private static void mostrarMenuOpciones() {
        System.out.println("Inscripciones maraton");
        System.out.println("1- Inscribir participante");
        System.out.println("2- Mostrar inscriptos");
        System.out.println("3- Desinscribir participante");
        System.out.println("4- Verificar monto a abonar");
        System.out.println("0- Salir");
    }
}
