package com.MELI.models;

import java.util.HashSet;
import java.util.Set;

public class Circuito {
    private int nInscripcion;
    private String tipo;
    private int distancia;
    private double costoMenor;
    private double costoMayor;
    private Set<Participante> participantes;

    public Circuito(String tipo, int distancia, double costoMenor, double costoMayor) {
        this.tipo = tipo;
        this.distancia = distancia;
        this.costoMenor = costoMenor;
        this.costoMayor = costoMayor;
        this.participantes = new HashSet<>();
    }

    //inscribir participantes
    public void addParticipantes(Participante participante){
        this.nInscripcion = participantes.size() + 1;
        this.participantes.add(participante);
    }

    //desinscribir participantes
    public void desinscribirParticipante(Participante participante) {
        this.participantes.remove(participante);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public double getCostoMenor() {
        return costoMenor;
    }

    public void setCostoMenor(double costoMenor) {
        this.costoMenor = costoMenor;
    }

    public double getCostoMayor() {
        return costoMayor;
    }

    public void setCostoMayor(double costoMayor) {
        this.costoMayor = costoMayor;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }

    public int getnInscripcion() {
        return nInscripcion;
    }

    public void setnInscripcion(int nInscripcion) {
        this.nInscripcion = nInscripcion;
    }

    @Override
    public String toString() {
        return "Circuito: " +
                "\nNumero de Inscripcion=" + nInscripcion +
                ",\n tipo='" + tipo + '\'' +
                ",\n distancia=" + distancia +
                ",\n costoMenor=" + costoMenor +
                ",\n costoMayor=" + costoMayor +
                ",\n participantes=" + participantes;
    }
}
