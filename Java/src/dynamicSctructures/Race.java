package dynamicSctructures;

import java.util.ArrayList;

public class Race {
    private ArrayList<Person> shortCircuit;
    private ArrayList<Person> mediumCircuit;
    private ArrayList<Person> advancedCircuit;

    public Race() {
        shortCircuit = new ArrayList<>();
        mediumCircuit = new ArrayList<>();
        advancedCircuit = new ArrayList<>();
    }

    public int subscription(String category, Person person) {
        if (shortCircuit.contains(person) || mediumCircuit.contains(person) || advancedCircuit.contains(person)) {
            System.out.println("Participante ya ingresado en el sistema");
            return -1;
        }
        switch (category) {
            case "short":
                shortCircuit.add(person);
                return person.getAge() < 18 ? 1300 : 1500;

            case "medium":
                mediumCircuit.add(person);
                return person.getAge() < 18 ? 2000 : 2300;

            case "advanced":
                if (person.getAge() > 18) {
                    advancedCircuit.add(person);
                    return 2800;
                }
                System.out.println("No se permiten menores de 18 años.");
                return -1;

            default:
                System.out.println("Categoria invalida.");
                return -1;
        }
    }

    public void unsubscription(Person person) {
        if (shortCircuit.contains(person)) {
            shortCircuit.remove(person);
            System.out.println("Participante removido correctamente");
        } else {
            if (mediumCircuit.contains(person)) {
                mediumCircuit.remove(person);
                System.out.println("Participante removido correctamente");
            } else {
                if (advancedCircuit.contains(person)) {
                    advancedCircuit.remove(person);
                    System.out.println("Participante removido correctamente");
                } else {
                    System.out.println("El participante no está inscripto");
                }
            }
        }
    }

    void printParticipant(Person p, int i) {
        System.out.println(
            "Participante número " + i + "\n" +
            "DNI: " + p.getId() + "\n" +
            "Nombre: " + p.getName() + "\n" +
            "Apellido: " + p.getLastName() + "\n" +
            "Celular: " + p.getPhone() + "\n" +
            "Teléfono de emergencia: " + p.getEmergencyPhone() + "\n" +
            "Grupo sanguiíneo: " + p.getBloodType() + "\n\n"
        );
    }

    public void showParticipants() {
        System.out.println("Participantes de circuito corto\n");
        for (int i=0; i< shortCircuit.size(); i++) {
            Person p = shortCircuit.get(i);
            printParticipant(p, i);
        }

        System.out.println("Participantes de circuito medio\n");
        for (int i=0; i< mediumCircuit.size(); i++) {
            Person p = mediumCircuit.get(i);
            printParticipant(p, i);
        }

        System.out.println("Participantes de circuito avanzado\n");
        for (int i=0; i< advancedCircuit.size(); i++) {
            Person p = advancedCircuit.get(i);
            printParticipant(p, i);
        }
    }
}
