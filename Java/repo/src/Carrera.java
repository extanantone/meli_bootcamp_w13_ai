import java.util.HashMap;
import java.util.LinkedList;

import static java.util.Objects.isNull;

public class Carrera {
    private LinkedList<Participante> inscriptosChico;
    private LinkedList<Participante> inscriptosMedio;
    private LinkedList<Participante> inscriptosAvanzado;
    private HashMap<Integer, Integer> inscriptos;

    public Carrera() {
        this.inscriptosChico = new LinkedList<>();
        this.inscriptosMedio = new LinkedList<>();
        this.inscriptosAvanzado = new LinkedList<>();
        this.inscriptos = new HashMap<>();
    }

    public void inscribir(Participante p, int categoria) {
        boolean esMenorParaAvanzado = false;
        if (isNull(this.inscriptos.get(p.getDni()))) {
            switch (categoria) {
                case 1:
                    this.inscriptosChico.add(p);
                    break;

                case 2:
                    this.inscriptosMedio.add(p);
                    break;

                case 3:
                    if (p.getEdad() >= 18) {
                        this.inscriptosAvanzado.add(p);
                    } else {
                        esMenorParaAvanzado = true;
                    }
                    break;
            }

            if (!esMenorParaAvanzado) {
                this.inscriptos.put(p.getDni(), 1);
                System.out.println("Nueva inscripción exitosa");
            } else System.out.println("No se puede inscribir un menor al circuito avanzado.");
        } else System.out.println("Inscripción repetida");
    }

    public void printInscriptosDe(int categoria) {
        int numInsc;
        switch (categoria) {
            case 1:
                numInsc = 1;
                for (Participante p : this.inscriptosChico) {
                    System.out.println("Nº: " + numInsc);
                    p.showParticipante();
                    numInsc++;
                }
                break;
            case 2:
                numInsc = 1;
                for (Participante p : this.inscriptosMedio) {
                    System.out.println("Nº: " + (this.inscriptosChico.size() + numInsc));
                    p.showParticipante();
                    numInsc++;
                }
                break;
            case 3:
                numInsc = 1;
                for (Participante p : this.inscriptosAvanzado) {
                    System.out.println("Nº: " + (this.inscriptosChico.size() + this.inscriptosMedio.size() + numInsc));
                    p.showParticipante();
                    numInsc++;
                }
                break;
        }
    }

    public void desinsciribir(int dni) {
        if (!isNull(this.inscriptos.get(dni))) {
            int categoria = this.inscriptos.get(dni);
            LinkedList<Participante> lista;

            switch (categoria) {
                case 1:
                    lista = this.inscriptosChico;
                    break;
                case 2:
                    lista = this.inscriptosMedio;
                    break;
                case 3:
                    lista = this.inscriptosAvanzado;
                    break;
                default:
                    lista = this.inscriptosChico;
                    break;
            }

            int indiceDesinsc = this.indiceDe(lista, dni);

            if (indiceDesinsc < lista.size()) {
                lista.remove(indiceDesinsc);
                System.out.println("Desinscripción exitosa de " + dni);
            } else System.out.println("Error: DNI presente en inscripciones pero no en categoría.");
            this.inscriptos.remove(dni);
        } else System.out.println("El presente DNI no coincide con ninguna inscripción actual.");
    }

    private int indiceDe(LinkedList<Participante> inscriptos, int dni) {
        int indice = 0;
        for (Participante p : inscriptos) {
            if (p.getDni() == dni) {
                break;
            }
            indice++;
        }
        return indice;
    }

    public int montoDe(int dni) {
        if (!isNull(this.inscriptos.get(dni))) {
            int categoria = this.inscriptos.get(dni);
            LinkedList<Participante> lista;

            switch (categoria) {
                case 1:
                    lista = this.inscriptosChico;
                    break;
                case 2:
                    lista = this.inscriptosMedio;
                    break;
                case 3:
                    lista = this.inscriptosAvanzado;
                    break;
                default:
                    lista = this.inscriptosChico;
                    break;
            }

            int indiceMonto = this.indiceDe(lista, dni);

            if (indiceMonto < lista.size()) {
                Participante p = lista.get(indiceMonto);
                int monto = 0;
                switch (categoria) {
                    case 1:
                        if (p.getEdad() < 18) monto = 1300;
                        else monto = 1500;
                        break;
                    case 2:
                        if (p.getEdad() < 18) monto = 2000;
                        else monto = 2300;
                        break;
                    case 3:
                        monto = 2800;
                        break;
                }
                return monto;
            } else {
                System.out.println("Error: DNI presente en inscripciones pero no en categoría.");
                return -1;
            }
        } else {
            System.out.println("Inscripción inválida.");
            return -1;
        }
    }

    public void borrarTodasLasInscripciones() {
        this.inscriptosChico.clear();
        this.inscriptosMedio.clear();
        this.inscriptosAvanzado.clear();
        this.inscriptos.clear();
    }

    public void demo() {
        this.borrarTodasLasInscripciones();

        Participante juan = new Participante(42876198, "Juan", "Pérez", 21,
                1156296472, 1132482311, "A negativo");
        Participante camilo = new Participante(21672539, "Camilo", "Suarez", 30,
                1123421983, 1157883926, "A positvo");
        Participante julia = new Participante(47892643, "Julia", "Menéndez", 17,
                1172198273, 1198342782, "AB negativo");
        Participante natalia = new Participante(19082372, "Natalia", "Gómez", 55,
                1144552233, 1185673564, "B positivo");
        Participante nicolas = new Participante(5002932, "Nicolás", "Palacios", 15,
                1109812932, 1155263874, "B negativo");

        this.inscribir(juan, 1);
        this.inscribir(camilo, 3);
        this.inscribir(julia, 2);
        this.inscribir(natalia, 1);
        this.inscribir(nicolas, 2);
    }
}