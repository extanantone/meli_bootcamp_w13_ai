import java.util.Scanner;

public class Main {
    static Carrera carrera = new Carrera();
    static Scanner sn = new Scanner(System.in);

    public static void main(String[] args) {
        Participante p;
        int opcion = 0;

        while (opcion != 8) {
            mostarMenu();
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    p = cargarParticipante();
                    carrera.inscribirParticipante(p, EnumCategorias.CHICO);
                    break;
                case 2:
                    p = cargarParticipante();
                    carrera.inscribirParticipante(p, EnumCategorias.MEDIANO);
                    break;
                case 3:
                    p = cargarParticipante();
                    carrera.inscribirParticipante(p, EnumCategorias.AVANZADO);
                    break;
                case 4:
                    System.out.print("\tIngresar dni de la persona: ");
                    String dni = sn.next();
                    carrera.desinscribirParticipante(dni);
                    break;
                case 5:
                    carrera.mostrarParticipantesDeCategoria(EnumCategorias.CHICO);
                    break;
                case 6:
                    carrera.mostrarParticipantesDeCategoria(EnumCategorias.MEDIANO);
                    break;
                case 7:
                    carrera.mostrarParticipantesDeCategoria(EnumCategorias.AVANZADO);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("La opcion ingresada es incorrecta");
                    System.out.print("Ingresar opcion: ");
                    opcion = sn.nextInt();
            }
        }
    }

    static void mostarMenu() {
        System.out.println("\nMENU");
        System.out.println("\t1- Inscribir a Circuito Chico");
        System.out.println("\t2- Inscribir a Circuito Medio");
        System.out.println("\t3- Inscribir a Circuito Avanzado");
        System.out.println("\t4- Desinscribir participante");
        System.out.println("\t5- Mostrar participantes Circuito Chico");
        System.out.println("\t6- Mostrar participantes Circuito Medio");
        System.out.println("\t7- Mostrar participantes Circuito Avanzado");
        System.out.println("\t8- Salir");
        System.out.print("Ingresar opcion: ");
    }

    static Participante cargarParticipante() {
        Participante p = new Participante();

        System.out.print("\tNombre: ");
        p.setNombre(sn.next());

        System.out.print("\tApellido: ");
        p.setApellido(sn.next());

        System.out.print("\tDni: ");
        p.setDni(sn.next());

        System.out.print("\tEdad: ");
        p.setEdad(sn.nextInt());

        System.out.print("\tCelular: ");
        p.setCelular(sn.next());

        System.out.print("\tNumero de emergencia: ");
        p.setNumeroEmergencia(sn.next());

        System.out.print("\tGrupo Sanguineo: ");
        p.setGrupoSanguineo(sn.next());

        return p;
    }
}
