package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Asteroid {

    public static List<Participante> ganadores;

    public static void play(List<Participante> participantes, List<Integer> posicionesX, List<Integer> posicionesY){
        int numeroDeCoordenadas = posicionesX.size();
        double minDistance = Double.MIN_VALUE;
        Participante currentWinner = new Participante();
        for(int i = 0; i < numeroDeCoordenadas; i++){
            for(Participante participante : participantes) {
                double participanteDistance = participante.getPosecion().getDistance(posicionesX.get(i),posicionesY.get(i));
                if(minDistance > participanteDistance){
                    minDistance = participanteDistance;
                    currentWinner = participante;
                }
            }
            currentWinner.setPuntaje(currentWinner.getPuntaje()+1);
            ganadores.add(currentWinner);
        }
    }

    public static void main(String[] args){
        List<Participante> participantes = new ArrayList<>();
        List<Integer> posicionesX = new ArrayList<>();
        List<Integer> posicionesY = new ArrayList<>();
        ganadores = new ArrayList<>();

        play(participantes,posicionesX,posicionesY);

    }
}
