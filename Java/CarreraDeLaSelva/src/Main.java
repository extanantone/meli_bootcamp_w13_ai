import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, Participante> participantes = new HashMap<Integer, Participante>();
        HashMap<Integer, Carrera> carreras = new HashMap<Integer, Carrera>();

        HashMap<Participante, Carrera> participantesEnCarrera = new HashMap<Participante, Carrera>();

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
                    asignarParticipanteACarrera(participantesEnCarrera, participantes, carreras);
                    break;
                case 3:
                    elimianrParticipanteDeCarrera(participantesEnCarrera, participantes, carreras);
                    break;
                case 4:
                    mostrarParticipantesDeCategoria(participantesEnCarrera, carreras);
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

        System.out.println("ingrese edad minima para el ingreso a la carrera");
        int edadMin = teclado.nextInt();

        System.out.println("ingrese edad maxima para el ingreso a la carrra");
        int edadMax = teclado.nextInt();

        System.out.println("ingrese monto para menores de edad");
        int montoMenores = teclado.nextInt();

        System.out.println("ingrese monto para mayores de edad");
        int montoMayores = teclado.nextInt();

        Carrera carrera = new Carrera(nombre,edadMin,edadMax,montoMenores,montoMayores);

        carreras.put(carrera.getCodigoCarrera(),carrera);
    }

    private static void mostrarParticipantesDeCategoria(HashMap<Participante,Carrera> participanteEnCarrera,
                                                        HashMap<Integer,Carrera> carreras) {

        final int PARTICIPANTE_18_ANIOS = 18;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Lista de categorias");

        for (Map.Entry<Integer, Carrera> entrada : carreras.entrySet()) {
            Carrera c = entrada.getValue();
            System.out.println(c.getCodigoCarrera() + " - " + c.getNombreCategoria());
        }

        System.out.println("Seleccione el CODIGO de carrera al que desea asignar al participante");

        int codCarrera = teclado.nextInt();

        for (Map.Entry<Participante, Carrera> entrada : participanteEnCarrera.entrySet()) {

            Carrera c = entrada.getValue();

            System.out.println("Lista de participantes");
            System.out.println("DNI    MONTO ABONADO");

            if (c.getCodigoCarrera() == codCarrera) {
                System.out.print(entrada.getKey().getDni());
                if (entrada.getKey().getEdad() >= PARTICIPANTE_18_ANIOS)
                    System.out.print(entrada.getValue().getMontoMayores());
                else
                    System.out.print(entrada.getValue().getMontoMenores());
            }
        }
    }

    private static void elimianrParticipanteDeCarrera(HashMap<Participante,Carrera> participanteEnCarrera,
                                                      HashMap<Integer,Participante> participantes,
                                                      HashMap<Integer,Carrera> carreras) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Lista de carreras");
        System.out.println("Cod. carrera   Nombre/Descripcion");

        for(Map.Entry<Integer,Carrera> entrada : carreras.entrySet()) {
            Carrera c = entrada.getValue();
            System.out.println(c.getCodigoCarrera() + " - " + c.getNombreCategoria());
        }

        System.out.println("Seleccione el CODIGO de carrera al que desea asignar al participante");

        int codCarrera = teclado.nextInt();

        Carrera carrera  = carreras.get(codCarrera);

        System.out.println("Lista de participantes");

        for (Map.Entry<Integer,Participante> entrada : participantes.entrySet()){
            Participante p = entrada.getValue();
            System.out.println(p.getDni() + " - " + p.getApellido() + " " + p.getNombre());
        }

        System.out.println("Seleccione el participante ingresando el numero de dni");

        int dni = teclado.nextInt();

        Participante participante  = participantes.get(dni);

        participanteEnCarrera.remove(participante);

        return;

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

        if(carrera.getMaxEdad() > participante.getEdad()){
            System.out.println("El participante no cumple con el requisito de edad");
            return;
        }

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
