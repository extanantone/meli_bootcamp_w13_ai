import models.Inscripcion;
import models.Persona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EjercicioSelva {

    public static List<Inscripcion> listaCircuitoChico = new ArrayList<Inscripcion>();
    public static List<Inscripcion> listaCircuitoMedio = new ArrayList<Inscripcion>();
    public static List<Inscripcion> listaCircuitoAvanzado = new ArrayList<Inscripcion>();

    public static HashMap<Integer, Integer> inscripcionesCircuitoChico = new HashMap<>();
    public static HashMap<Integer, Integer> inscripcionesCircuitoMediano= new HashMap<>();
    public static HashMap<Integer, Integer> inscripcionesCircuitoAvanzado = new HashMap<>();

    public static void main(String[] args){

        Persona Persona1 = new Persona (33333333, 11111, 223211, 30, "Pablo", "Guayta","A+");
        Persona Persona2 = new Persona (33333334, 11111, 223211, 15, "Jorge", "Guayta","A+");

        Persona Persona3 = new Persona (33333335, 11111, 223211, 11, "Matias", "Guayta","A+");
        Persona Persona4 = new Persona (33333336, 11111, 223211, 25, "Eli", "Guayta","A+");

        Persona Persona5 = new Persona (33333337, 11111, 223211, 18, "Hora", "Guayta","A+");
        Persona Persona6 = new Persona (33333338, 11111, 223211, 28, "Lean", "Guayta","A+");


        //Inscripciones
        Inscripcion inscripcion1 = new Inscripcion(1,1,Persona1);
        Inscripcion inscripcion2 = new Inscripcion(2,1,Persona2);

        Inscripcion inscripcion3 = new Inscripcion(1,2,Persona3);
        Inscripcion inscripcion4 = new Inscripcion(2,2,Persona4);

        Inscripcion inscripcion5 = new Inscripcion(1,3,Persona5);
        Inscripcion inscripcion6 = new Inscripcion(2,3,Persona6);


        listaCircuitoChico.add(inscripcion1);
        listaCircuitoChico.add(inscripcion2);

        listaCircuitoMedio.add(inscripcion3);
        listaCircuitoMedio.add(inscripcion4);

        listaCircuitoAvanzado.add(inscripcion5);
        listaCircuitoAvanzado.add(inscripcion6);

        int opcion = Integer.MAX_VALUE;

        Scanner entradaTeclado = new Scanner(System.in);

        System.out.println("Ingrese un valor entre 0 y 5");
        System.out.println("1 - Asignar nuevo participante a carrera");
        System.out.println("2 - Mostrar participantes por id de carrera");
        System.out.println("3 - Desinscribir participante");
        System.out.println("4 - Calcular monto por por edad de participante y carrera");
        System.out.println("0 - Salir del programa");
        opcion = entradaTeclado.nextInt();

        while (opcion != 0) {

            switch (opcion) {

                case 1:
                    createAndAsignNewParticipant();
                    break;
                case 2:
                    showParticipantsByCircuitID();
                    break;
                case 3:
                    //elimianrParticipanteDeCarrera();
                    break;
                case 4:
                    //mostrarParticipantesDeCategoria(participantesEnCarrera,carreras);
                    break;
                case 5:
                    //crearCarrera(carreras);
                    break;
                default:
                    System.out.println("Error al ingresar por teclado, intente nuevamente");
                    break;
            }

            System.out.println("Ingrese un valor entre 0 y 5");
            opcion = entradaTeclado.nextInt();
        }

        return;
    }



    public static void createAndAsignNewParticipant (){

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese dni del participante");
        int dni = teclado.nextInt();
        System.out.println("Ingrese nombre del participante");
        String nombre = teclado.next();
        System.out.println("Ingrese apellido del participante");
        String apellido = teclado.next();
        System.out.println("Ingrese número de emergencia del participante, sin guiones o espacios");
        int nroEmergencia = teclado.nextInt();
        System.out.println("Ingrese grupo sanguineo del participante");
        String grupoSanguineo = teclado.next();
        System.out.println("Ingrese celular del participante, sin guiones o espacios");
        int celular = teclado.nextInt();
        System.out.println("Ingrese edad del participante");
        int edad = teclado.nextInt();
        System.out.println("Ingrese el circuito al que desea inscribir al participante");
        int circuitoID = teclado.nextInt();

        Persona participante = new Persona(dni,celular,nroEmergencia,edad,nombre,apellido,grupoSanguineo);
        Inscripcion nuevaInscripcion;

        switch (circuitoID){

            case Inscripcion.CIRCUITO_CHICO:
                nuevaInscripcion = new Inscripcion(listaCircuitoChico.size()+1,1,participante);
                listaCircuitoChico.add(nuevaInscripcion);
                inscripcionesCircuitoChico.put(dni,listaCircuitoChico.size());
                break;

            case Inscripcion.CIRCUITO_MEDIO:
                nuevaInscripcion = new Inscripcion(listaCircuitoMedio.size()+1,2,participante);
                listaCircuitoMedio.add(nuevaInscripcion);
                inscripcionesCircuitoMediano.put(dni,listaCircuitoMedio.size());
                break;

            case Inscripcion.CIRCUITO_AVANZADO:
                nuevaInscripcion = new Inscripcion(listaCircuitoAvanzado.size()+1,3,participante);
                listaCircuitoAvanzado.add(nuevaInscripcion);
                inscripcionesCircuitoAvanzado.put(dni,listaCircuitoAvanzado.size());
                break;
        }


    }


    public static void showParticipantsByCircuitID () {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el ID del circuito para mostrar los participantes");
        int circuitoID = teclado.nextInt();
        int i = 0;
        for (Inscripcion insc: listaCircuitoChico){

            System.out.println("Numero de inscripcion: " + insc.numeroInscripcion);
            System.out.println("Dni: " + insc.getParticipante().getDni());
            System.out.println("Nombre: " + insc.getParticipante().getNombre());


        }


    }

    public static void elimianrParticipanteDeCarrera(){

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese dni del participante");
        int dni = teclado.nextInt();

        if(inscripcionesCircuitoChico.get(dni)!=null){

            int index = inscripcionesCircuitoChico.get(dni).intValue();

            inscripcionesCircuitoChico.remove(39879820);

            for(int i = index; i<listaCircuitoChico.size();i++){

                //listaCircuitoChico.get(i).setNumeroInscripcion();
            }


        }




    }

}
