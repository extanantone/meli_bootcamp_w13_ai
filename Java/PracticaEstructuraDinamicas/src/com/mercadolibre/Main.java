package com.mercadolibre;

import com.mercadolibre.dominio.Persona;
import java.util.*;

public class Main {
    private static String CIRCUITO_CHICO = "Circuito Chico";
    private static String CIRCUITO_MEDIO = "Circuito Medio";
    private static String CIRCUITO_AVANZADO = "Circuito Avanzado";
    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int cantInscriptos = 1; //Solo sumo 1 para que arranque las inscripciones con 1
        String[]categoriasDefault = {CIRCUITO_CHICO,CIRCUITO_MEDIO,CIRCUITO_AVANZADO};
        List<String> categoria = new ArrayList<>(Arrays.asList(categoriasDefault));
        Map<Integer,Persona> inscripciones = new HashMap<>();
        boolean salir = false;
        do{
            mostrarMenuOpciones();
            Scanner input = new Scanner(System.in);
            System.out.println("Ingrese una opcion: ");
            int option = input.nextInt();
            int idParticipante;
            switch (option){
                case 1:
                    Persona persona = new Persona();
                    persona.setIdIncripcion(cantInscriptos);
                    System.out.println("id: "  +persona.getIdIncripcion());
                    Persona personaInscripta= incribirPersona(persona,categoria);
                    boolean existeParticipante = inscripciones.values().stream().anyMatch(persona1 -> persona1.getDni() == persona.getDni());
                    if(!existeParticipante){
                        inscripciones.put(cantInscriptos,personaInscripta);
                        cantInscriptos ++;
                    } else {
                        System.out.println("El numero de DNI " + (int) persona.getDni() + " ya se encuentra registrado");
                    }
                    break;
                case 2:
                    mostrarIncriptos(inscripciones);
                    break;
                case 3:
                    idParticipante = findPersonById(inscripciones);
                    desinscribirParticipante(inscripciones,idParticipante);
                    break;
                case 4:
                    //TODO en base a la edad del participante y la categoria en la
                    // que se inscriba mostrar monto a abonar, no tengo claro si es la lista total con monto a abonar o realizar el calculo por cada participante
                    idParticipante = findPersonById(inscripciones);
                    double monto = calcularMontoAbonar(idParticipante,inscripciones);
                    if(monto == -1) inscripciones.remove(idParticipante);
                    else System.out.println("El monto total a abonar es de $" + monto);
                    //TODO se deberia optimizar y no permitir el registro del participante cuando indica la edad y el circuito, dandole la posibilidad de cambiar
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("La opcion ingresada es incorrecta");
            }
        } while(!salir);
    }

    private static double calcularMontoAbonar(int idParticipante, Map<Integer, Persona> inscripciones) {
        double montoTotal = 0;
        if(inscripciones.get(idParticipante).getEdad()<18){
            if(inscripciones.get(idParticipante).getCategoria().equals(CIRCUITO_CHICO)){
                montoTotal = 1300;
            } else if(inscripciones.get(idParticipante).getCategoria().equals(CIRCUITO_MEDIO)){
                montoTotal = 2000;
            } else{
                System.out.println("No se permiten inscripciones de menores de 18 años al circuito avanzado");
                montoTotal = -1; //TODO como esta ahora debo eliminar la incripcion del participante
            }
        } else{
            if(inscripciones.get(idParticipante).getCategoria().equals(CIRCUITO_CHICO)){
                montoTotal = 1500;
            } else if(inscripciones.get(idParticipante).getCategoria().equals(CIRCUITO_MEDIO)){
                montoTotal = 2300;
            } else{
                montoTotal = 2800;
            }
        }
        return montoTotal;
    }

    private static int findPersonById(Map<Integer, Persona> inscripciones) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el numero de documento del participante: ");
        double dni = input.nextDouble();
        if(inscripciones.size()!=0){
            for (Map.Entry<Integer,Persona>participante : inscripciones.entrySet()) {
                if(participante.getValue().getDni() == dni){
                    return participante.getValue().getIdIncripcion();
                }
            }
            return -1;
        } else{
            return 0;
        }


    }

    private static void desinscribirParticipante(Map<Integer, Persona> inscripciones, int idInscripcion) {
        if(inscripciones.size()==0){
            System.out.println("No hay ningún participante inscripto a la carrera");
        } else {
              if(idInscripcion!=-1 && idInscripcion!=0){
                  System.out.println("voy a eliminar al participante: " + inscripciones.get(idInscripcion));
                  inscripciones.remove(idInscripcion);
              } else{
                  System.out.println("El participante no se encuentra registrado");
              }
        }
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
        boolean salir = true;
        int numCategoria = input.nextInt();
        if(numCategoria<=0 || numCategoria>categorias.size()){
            System.out.println("El numero ingresado no pertenece a ninguna categoria");
        } else {
            System.out.println("Ingrese el dni de la persona: ");
            persona.setDni(input.nextInt());
            //TODO deberia crear alguna validacion y solo inscribir al participante si no se encuentra registrado dni
            persona.setCategoria(categorias.get(numCategoria - 1));
            System.out.println("Ingrese el nombre: ");
            persona.setNombre(inputDatos.nextLine());
            System.out.println("Ingrese el apellido: ");
            persona.setApellido(inputDatos.nextLine());
            System.out.println("Ingrese la edad de la persona: ");
            persona.setEdad(input.nextInt());
            System.out.println("Ingrese el grupo sanguineo: ");
            persona.setGrupoSanguineo(inputDatos.nextLine());
            System.out.println("Ingrese un numero de emergencia: ");
            persona.setNumeroEmergencia(inputNumeros.nextDouble());
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
