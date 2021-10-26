package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ejercicioCarreraSelva {

    List<Participante> listaParticipantes = new ArrayList<>();
    HashMap<Integer, Participante> circuitoChico = new HashMap<>();
    HashMap<Integer, Participante> circuitoMedio = new HashMap<>();
    HashMap<Integer, Participante> circuitoAvanzado = new HashMap<>();

    Participante juan = new Participante(156, "Juan", "Perez", 3338490, "O+", 32193193, 21);
    Participante marcos = new Participante(256, "Marcos", "Lopez", 3338491, "O+", 32193193, 14);
    Participante carlos = new Participante(356, "Carlos", "Alvarez", 3338492, "O+", 32193193, 15);
    Participante maria = new Participante(456, "Maria", "Granjas", 3138491, "O+", 32193193, 24);
    Participante carla = new Participante(556, "Carla", "Moreno", 3328591, "O+", 32193193, 31);

    public void inscribirParticipantes(){
        listaParticipantes.add(juan);
        listaParticipantes.add(marcos);
        listaParticipantes.add(carlos);
        listaParticipantes.add(maria);
        listaParticipantes.add(carla);

        int aporte;
        int menor;
        int circuitoAleatorio;

        for (Participante p: listaParticipantes) {
            aporte = 0;
            menor = p.getEdad() < 18 ? 2:3;
            circuitoAleatorio = 0;
            circuitoAleatorio = (int)(Math.random()*menor) + 1;

            if (circuitoAleatorio == 1){
                int participante = circuitoChico.size();
                aporte = menor==2 ? 1300:1500;
                p.setAporte(aporte);
                circuitoChico.put(participante+1,p);
            }
            else if(circuitoAleatorio == 2){
                int participante = circuitoMedio.size();
                aporte = menor == 2 ? 2000:2300;
                p.setAporte(aporte);
                circuitoMedio.put(participante+1,p);
            }
            else{
                int participante = circuitoAvanzado.size();
                p.setAporte(2800);
                circuitoAvanzado.put(participante+1,p);
            }
        }

        System.out.println("Lista de Inscritos a circuitos");
        System.out.println("------------------------------");
        System.out.println("Circuito Chico");
        for (Map.Entry<Integer, Participante> p: circuitoChico.entrySet()) {
            System.out.println("Participante "+p.getKey()+": Nombre - "+p.getValue().getNombre()+" Edad: "+p.getValue().getEdad()+" Aporte: "+p.getValue().getAporte());
        }
        System.out.println();
        System.out.println("Circuito Medio");
        for (Map.Entry<Integer, Participante> p: circuitoMedio.entrySet()) {
            System.out.println("Participante "+p.getKey()+": Nombre - "+p.getValue().getNombre()+" Edad: "+p.getValue().getEdad()+" Aporte: "+p.getValue().getAporte());
        }
        System.out.println();
        System.out.println("Circuito Avanzado");
        for (Map.Entry<Integer, Participante> p: circuitoAvanzado.entrySet()) {
            System.out.println("Participante "+p.getKey()+": Nombre - "+p.getValue().getNombre()+" Edad: "+p.getValue().getEdad()+" Aporte: "+p.getValue().getAporte());
        }
    }


    public static void main(String[] args) {
       // new ejercicioCarreraSelva().inscribirParticipantes();
    }

}
