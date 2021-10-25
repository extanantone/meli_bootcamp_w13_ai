import java.util.LinkedList;
import java.util.List;

class Main {
    static List<Participante> circuitoChico = new LinkedList<>();
    static List<Participante> circuitoMedio = new LinkedList<>();
    static List<Participante> circuitoAvanzado = new LinkedList<>();
    static int countParticipants;

    private static int inscribirParticipante(Participante participante, String circuito) {
        int coste, numParticipante;

        if (circuitoChico.contains(participante) || circuitoMedio.contains(participante) || circuitoAvanzado.contains(participante))
        {
            System.out.println("-> El participante ya está registrado");
            return (0);
        }
        System.out.println("-> Agregando participante: " + participante.getNombre() + " a circuito: " + circuito);
        switch (circuito)
            {
                //circuito chico
                case "chico":
                    circuitoChico.add(participante);
                    coste = participante.getEdad() > 18 ? 1500 : 1300;
                    System.out.println("Costo de la inscripción: " + coste + "$");
                    numParticipante = countParticipants++;
                    participante.setNumParticipante(numParticipante);
                    System.out.println("Numero de participante circuito: " + circuito + " : " + numParticipante);
                    return coste;
                //circuito medio
                case "medio":
                    circuitoMedio.add(participante);
                    coste = participante.getEdad() > 18 ? 2300 : 2000;
                    System.out.println("Costo de la inscripción: " + coste + "$");
                    numParticipante = countParticipants++;
                    participante.setNumParticipante(numParticipante);
                    System.out.println("Numero de participante circuito: " + circuito + " : " + numParticipante);
                    return coste;
                //circuito circuitoAvanzado
                case "avanzado":
                   if (participante.getEdad() < 18)
                   {
                       System.out.println("No puede participar un menor de edad");
                       return (0);
                   }
                    circuitoAvanzado.add(participante);
                    coste = 2800;
                    System.out.println("Costo de la inscripción: " + coste + "$");
                    numParticipante = countParticipants++;
                    participante.setNumParticipante(numParticipante);
                    System.out.println("Numero de participante circuito: " + circuito + " : " + numParticipante);
                    return coste;
                default:
                    System.out.println("Circuito no reconocido");
                    return (0);
            }
    }

    private static void desinscribirParticipante(Participante participante)
    {
        if (circuitoChico.contains(participante))
        {
            System.out.println("-> Eliminado participante: " + participante + " de circuito chico");
            circuitoChico.remove(participante);
            return;
        }
        else if (circuitoMedio.contains(participante))
        {
            System.out.println("-> Eliminado participante: " + participante + " de circuito medio");
            circuitoMedio.remove(participante);
            return;
        }
        else if (circuitoAvanzado.contains(participante))
        {
            System.out.println("-> Eliminado participante: " + participante + " de circuito avanzado");
            circuitoAvanzado.remove(participante);
            return;
        }
        System.out.println("El participante no se encuentra en ningún circuito");
    }

    private static void mostrarParticipantes()
    {
        System.out.println("****************** PARTICIPANTES ********************");
        System.out.println("Circuito chico: ");
        System.out.println(circuitoChico.toString());
        System.out.println("Circuito medio: ");
        System.out.println(circuitoMedio.toString());
        System.out.println("Circuito avanzado: ");
        System.out.println(circuitoAvanzado.toString());
    }

    public static void main(String[] args) {
        int costoInscripcion;

        Participante juan = new Participante(156, "Juan", "Perez", 3338490, "O+", 32193193, 21);
        Participante marcos = new Participante(256, "Marcos", "Lopez", 3338491, "O+", 32193193, 14);
        Participante carlos = new Participante(356, "Carlos", "Alvarez", 3338492, "O+", 32193193, 15);
        Participante maria = new Participante(456, "Maria", "Granjas", 3138491, "O+", 32193193, 24);
        Participante carla = new Participante(556, "Carla", "Moreno", 3328591, "O+", 32193193, 31);

        costoInscripcion = inscribirParticipante(juan, "chico");
        costoInscripcion = inscribirParticipante(marcos, "chico");
        costoInscripcion = inscribirParticipante(juan, "medio");
        desinscribirParticipante(juan);
        costoInscripcion = inscribirParticipante(juan, "medio");
        costoInscripcion = inscribirParticipante(carlos, "avanzado");
        costoInscripcion = inscribirParticipante(maria, "avanzado");
        costoInscripcion = inscribirParticipante(carla, "avanzado");

        mostrarParticipantes();

    }
}