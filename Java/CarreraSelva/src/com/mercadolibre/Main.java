package com.mercadolibre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<Person> participants = new ArrayList<>();
        List<Circuit> circuits = new ArrayList<>();
        Map<Long, Integer> inscriptionList = new HashMap<>();

        circuits.add(new Circuit(
                1,
                "Circuito chico",
                new int[]{1300, 1500},
                "2 km por selva y arroyos. Menores de 18 años $1300. Mayores de 18 años $1500."
        ));
        circuits.add(new Circuit(
                2,
                "Circuito medio",
                new int[]{2000, 2300},
                "2 km por selva y arroyos. Menores de 18 años $1300. Mayores de 18 años $1500."
        ));
        circuits.add(new Circuit(
                1,
                "Circuito chico",
                new int[]{-1, 2800},
                "2 km por selva y arroyos. Menores de 18 años $1300. Mayores de 18 años $1500."
        ));

        int participantInscriptionIndex = 1;

        System.out.println("Insertando participantes...");
        for (int i = 0; i < 30; i++) {

            boolean personIsAllowed = true;
            String notAllowedReason = "";

            Person participant = new Person(
                    participantInscriptionIndex,
                    (int) Math.floor(Math.random()*(31)),
                    "part"+participantInscriptionIndex,
                    (int) Math.floor(Math.random()*(19-17+1)+17)
            );
            Circuit circuit = circuits.get((int) Math.floor(Math.random()*3));
            if (circuit.inscriptionPrices[0] == -1 && participant.age < 18) {
                personIsAllowed = false;
                notAllowedReason = "Age";
            }
            if (inscriptionList.containsKey(participant.dni)) {
                personIsAllowed = false;
                notAllowedReason = "Repeated";
            }
            if (personIsAllowed) {
                inscriptionList.put(participant.dni, circuit.id);
                participantInscriptionIndex ++;
            }
            System.out.println(participant.toString() + " " + circuit.toString() + " Allowed: " + personIsAllowed + " " + notAllowedReason);
        }
    }
}
