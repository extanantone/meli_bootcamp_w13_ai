import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer,Participante> participantes = new HashMap<Integer, Participante>();
        HashMap<Integer,Carrera> carreras = new HashMap<Integer,Carrera>();

        HashMap<Participante,Carrera> participantesEnCarrera = new HashMap<Participante,Carrera>();

        int opcion = Integer.MAX_VALUE;

        Scanner entradaTeclado = new Scanner(System.in);

        System.out.println("Ingrese un valor entre 0 y 5");
        System.out.println("1 - Nuevo participante");
        System.out.println("2 - Asignar participante a carrera");
        System.out.println("3 - Eliminar participante de carrera");
        System.out.println("4 - Mostrar participantes de una carrera");
        System.out.println("5 - Crear nueva carrera");
        System.out.println("");
        System.out.println("0 - Salir del programa");
        opcion = entradaTeclado.nextInt();

        while (opcion != 0) {

            switch (opcion) {

                case 1:
                    crearParticipante(participantes);
                    break;
                case 2:
                    asignarParticipanteACarrera(participantesEnCarrera,participantes,carreras);
                    break;
                case 3:
                    elimianrParticipanteDeCarrera();
                    break;
                case 4:
                    mostrarParticipantesDeCategoria(participantesEnCarrera,carreras);
                    break;
                case 5:
                    crearCarrera(carreras);
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

    private static void crearCarrera(HashMap<Integer,Carrera> carreras) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("ingrese Nombre/Descripcion de la carrera");
        String nombre = teclado.next();

        Carrera carrera = new Carrera(nombre);

        carreras.put(carrera.getCodigoCarrera(),carrera);
    }

    private static void mostrarParticipantesDeCategoria(HashMap<Participante,Carrera> participanteEnCarrera,
                                                        HashMap<Integer,Carrera> carreras) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Lista de categorias");

        for(Map.Entry<Integer,Carrera> entrada : carreras.entrySet()) {
            Carrera c = entrada.getValue();
            System.out.println(c.getCodigoCarrera() + " - " + c.getNombreCategoria());
        }

        System.out.println("Seleccione el CODIGO de carrera al que desea asignar al participante");

        int codCarrera = teclado.nextInt();

        for(Map.Entry<Participante,Carrera> entrada : participanteEnCarrera.entrySet()) {

            Carrera c = entrada.getValue();

            System.out.println("Lista de participantes");

            if(c.getCodigoCarrera() == codCarrera)
                System.out.println(entrada.getKey().getDni());

        }

    }

    private static void elimianrParticipanteDeCarrera() {

    }

    private static void asignarParticipanteACarrera(HashMap<Participante,Carrera> participanteEnCarrera,
                                                    HashMap<Integer,Participante> participantes,
                                                    HashMap<Integer,Carrera> carreras) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Lista de participantes");

        for (Map.Entry<Integer,Participante> entrada : participantes.entrySet()){
            Participante p = entrada.getValue();
            System.out.println(p.getDni() + " - " + p.getApellido() + " " + p.getNombre());
        }

        System.out.println("Seleccione el participante ingresando el numero de dni");

        int dni = teclado.nextInt();

        Participante participante  = participantes.get(dni);

        System.out.println("Lista de carreras");
        System.out.println("Cod. carrera   Nombre/Descripcion");

        for(Map.Entry<Integer,Carrera> entrada : carreras.entrySet()) {
            Carrera c = entrada.getValue();
            System.out.println(c.getCodigoCarrera() + " - " + c.getNombreCategoria());
        }

        System.out.println("Seleccione el CODIGO de carrera al que desea asignar al participante");

        int codCarrera = teclado.nextInt();

        Carrera carrera  = carreras.get(codCarrera);

        participanteEnCarrera.put(participante,carrera);

    }

    private static void crearParticipante(HashMap<Integer,Participante> participantes) {

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

        Participante participante = new Participante(dni,nombre,apellido,nroEmergencia,grupoSanguineo,celular,edad);

        participantes.put(dni,participante);

    }
}
