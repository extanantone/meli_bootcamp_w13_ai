package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Rastreable> participantes = new ArrayList<>();

        // Seteo una nave y la agrego como participante
        Nave nave = new Nave(3, 5);
        nave.setNombre("Solitaria");
        participantes.add(nave);

        // Seteo una nave y la agrego como participante
        Nave nave2 = new Nave(-3, 2);
        nave2.setNombre("El halcon milenario");
        participantes.add(nave2);

        // Seteo una flota y la agrego como participante
        Flota flota = new Flota();
        flota.setNombre("Flota");
        flota.agregarNave(new Nave(-2, 4));
        flota.agregarNave(new Nave(7, 1));
        flota.agregarNave(new Nave(0, -3));
        flota.agregarNave(new Nave(-4, 9));
        participantes.add(flota);

        // Lista de coordenadas de la competencia
        List<double[]> coordenadasCompetencia = new ArrayList<>();
        coordenadasCompetencia.add(new double[]{3, -2});
        coordenadasCompetencia.add(new double[]{-3, 1});
        coordenadasCompetencia.add(new double[]{7, 8});
        coordenadasCompetencia.add(new double[]{0, -5});
        coordenadasCompetencia.add(new double[]{-7, 1});
        coordenadasCompetencia.add(new double[]{3, 0});

        // Vector con puntos acumulados de cara participante por ronda
        int [] puntos = new int[participantes.size()];

        // Por cada una de las rondas
        for (double[] coord : coordenadasCompetencia){
            System.out.println("\n -----Nueva ronda------");
            System.out.println("Coordenadas : " + coord[0] + " / " + coord[1]);
            // El ganador al principio sera el primero hasta que otro le gane
            int idxGanador = 0;
            double menorCercania = participantes.get(0).CalcularCercania(coord[0], coord[1]);
            System.out.println("Cercania participante 0 : " + menorCercania);
            // Recorro cada participante y comparo sus cercanias para saber el ganador en cada una
            for(int i = 1; i<participantes.size(); i++) {
                double cercaniaParticipanteI = participantes.get(i).CalcularCercania(coord[0], coord[1]);
                if(cercaniaParticipanteI < menorCercania){
                    idxGanador = i;
                    menorCercania = cercaniaParticipanteI;
                }
                System.out.println("Cercania participante " + i + " : " + cercaniaParticipanteI);
            }
            System.out.println("****Ganador participante " + idxGanador);
            // Le sumo un punto al ganador de la ronda
            puntos[idxGanador] += 1;
        }

        // Recorro los puntos para saber el ganador
        int puntosGanador = puntos[0];
        int idxGanadorCompetencia = 0;
        for (int i = 1; i<puntos.length; i++){
            if(puntos[i] > puntosGanador){
                puntosGanador = puntos[i];
                idxGanadorCompetencia = i;
            }
        }
        System.out.println("\n --------------------------------------");
        System.out.println("Gano " + participantes.get(idxGanadorCompetencia).getNombre() + " con " + puntosGanador + " puntos");
    }
}
