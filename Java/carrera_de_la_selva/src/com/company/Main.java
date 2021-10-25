package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        List<Persona> participantes = new ArrayList<>();

        participantes.add(new Persona(154344303, "Juan", "Fernandez", 25, 351341533, 23403456, "A+" ));
        participantes.add(new Persona(240674304, "Pepe", "Di Marco", 17, 351341534, 303423456, "0-" ));
        participantes.add(new Persona(143243216, "Jose", "Donatti", 56, 351345334, 334343456, "A+" ));
        participantes.add(new Persona(453455430, "Marcos", "Poe", 21, 351315334, 304343456, "B+" ));
        participantes.add(new Persona(403453451, "Lucas", "Lozada", 15, 351415334, 787678456, "AB+" ));
        participantes.add(new Persona(33998877, "Sebastian", "villalba", 14, 356353536, 345665544, "0+"));
        participantes.add(new Persona(12334455, "Roberto", "Perez", 22, 4435662, 44352632, "AB+"));

        //se crean las 3 estructuras que contienen los participantes de las 3 categorias
        //la key es el numero de inscripcion
        Map<Integer, Persona> Circuito_chico = new HashMap<>();
        Map<Integer, Persona> Circuito_medio = new HashMap<>();
        Map<Integer, Persona> Circuito_avanzado = new HashMap<>();

        //se inscriben los participantes de forma pseudoaleatoria de acuerdo a su dni
        for (int i = 0; i < participantes.size(); i++) {
            if (participantes.get(i).getEdad() < 18 ){
                if (participantes.get(i).getDni() % 2 == 0){
                    Circuito_chico.put(Circuito_chico.size() + 1, participantes.get(i));
                }else {
                    Circuito_medio.put(Circuito_medio.size() + 1, participantes.get(i));
                }
            }else {
                switch (participantes.get(i).getDni() % 3){
                    case 0:
                        Circuito_chico.put(Circuito_chico.size() + 1, participantes.get(i));
                        break;
                    case 1:
                        Circuito_medio.put(Circuito_medio.size() + 1, participantes.get(i));
                        break;
                    case 2:
                        Circuito_avanzado.put(Circuito_avanzado.size() + 1, participantes.get(i));
                        break;
                }
            }
        }

        System.out.println("-----Circuito Chico-----");
        printCategorias(Circuito_chico, 1300, 1500);
        System.out.println("-----Circuito Medio-----");
        printCategorias(Circuito_medio, 2000, 2300);
        System.out.println("-----Circuito Avanzado-----");
        printCategorias(Circuito_avanzado, 2800, 2800);

        System.out.println(participantes.get(2) + " | Monto a pagar: " + determinarMontoInscripcion(Circuito_chico, Circuito_medio, Circuito_avanzado, participantes.get(2)));

        desinscribirParticipante(Circuito_chico, 1);
        desinscribirParticipante(Circuito_chico, 2);
        desinscribirParticipante(Circuito_avanzado, 1);

        System.out.println("\n------------------------------------------------\n");
        System.out.println("-----Circuito Chico-----");
        printCategorias(Circuito_chico, 1300, 1500);
        System.out.println("-----Circuito Medio-----");
        printCategorias(Circuito_medio, 2000, 2300);
        System.out.println("-----Circuito Avanzado-----");
        printCategorias(Circuito_avanzado, 2800, 2800);

    }
    public static int determinarMontoInscripcion(Map<Integer, Persona> circChico, Map<Integer, Persona> circMedio, Map<Integer, Persona> circAvanzado, Persona per){
        if(circChico.containsValue(per)){
            if(per.getEdad() >= 18){
                return 1500;
            } else return 1300;
        } else if(circMedio.containsValue(per)) {
            if(per.getEdad() >= 18){
                return 2300;
            } else return 2000;
        } else if(circAvanzado.containsValue(per)){
            return 2800;
        } else {
            return -1;
        }
    }

    public static void desinscribirParticipante(Map<Integer, Persona> circuito, Integer nroInscripcion){
        circuito.remove(nroInscripcion);
    }

    public static void printCategorias(Map<Integer, Persona> circuito, int precioMenor, int precioMayor){
        for (Map.Entry<Integer, Persona> participante : circuito.entrySet()){
            int price;
            if (participante.getValue().getEdad() >= 18){
                price = precioMayor;
            }else {
                price = precioMenor;
            }
            System.out.println("Participante nro " + participante.getKey() + " | " + participante.getValue() + " | Pagará $" + price);
        }
    }
}
