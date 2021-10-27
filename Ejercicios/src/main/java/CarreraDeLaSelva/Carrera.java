package CarreraDeLaSelva;

import java.util.ArrayList;


public class Carrera {


    private ArrayList<Participante> circuitoChico;
    private ArrayList<Participante> circuitoMedio;
    private ArrayList<Participante> circuitoAvanzado;

    public Carrera() {
        circuitoChico = new ArrayList<>();
        circuitoMedio = new ArrayList<>();
        circuitoAvanzado = new ArrayList<>();
    }

    public int subscripcion(String category, Participante participante) {
        if (circuitoChico.contains(participante)
                || circuitoMedio.contains(participante)
                || circuitoAvanzado.contains(participante)) {
            System.out.println("Participante ya ingresado en el sistema");
            return -1;
        }
        switch (category) {
            case "chico":
                circuitoChico.add(participante);
                return participante.getEdad() < 18 ? 1300 : 1500;

            case "medio":
                circuitoMedio.add(participante);
                return participante.getEdad() < 18 ? 2000 : 2300;

            case "avanzado":
                if (participante.getEdad() > 18) {
                    circuitoAvanzado.add(participante);
                    return 2800;
                }
                System.out.println("No se permiten menores de 18 años.");
                return -1;

            default:
                System.out.println("Categoria invalida.");
                return -1;
        }
    }

    public void eliminarParticipante(Participante participante) {
        if (circuitoChico.contains(participante)) {
            circuitoChico.remove(participante);
            System.out.println("Participante eliminado");
        } else {
            if (circuitoMedio.contains(participante)) {
                circuitoMedio.remove(participante);
                System.out.println("Participante eliminado");
            } else {
                if (circuitoAvanzado.contains(participante)) {
                    circuitoAvanzado.remove(participante);
                    System.out.println("Participante eliminado");
                } else {
                    System.out.println("El participante no está inscripto");
                }
            }
        }
    }

    void printParticipantes(Participante p, int i) {
        System.out.println(
                "Participante número " + i + "\n" +
                        "DNI: " + p.getDni() + "\n" +
                        "Nombre: " + p.getNombre() + "\n" +
                        "Apellido: " + p.getApellido() + "\n" +
                        "Celular: " + p.getCelular() + "\n" +
                        "Teléfono de emergencia: " + p.getNroEmergencia() + "\n" +
                        "Grupo sanguíneo: " + p.getGrupoSanguineo() + "\n\n"
        );
    }

    public void mostrarParticipantes() {
        System.out.println("Participantes de circuito chico\n");
        for (int i = 0; i < circuitoChico.size(); i++) {
            Participante p = circuitoChico.get(i);
            printParticipantes(p, i);
        }

        System.out.println("Participantes de circuito medio\n");
        for (int i = 0; i < circuitoMedio.size(); i++) {
            Participante p = circuitoMedio.get(i);
            printParticipantes(p, i);
        }

        System.out.println("Participantes de circuito avanzado\n");
        for (int i = 0; i < circuitoAvanzado.size(); i++) {
            Participante p = circuitoAvanzado.get(i);
            printParticipantes(p, i);
        }
    }
}

