package com.MELI.models;

public class Inscripcion {
    private int nInscripcion;
    private Circuito circuito;
    private Participante participante;
    private double valorInscripcion;

    public Inscripcion(Circuito circuito, Participante participante, double valorInscripcion) {
        this.circuito = circuito;
        this.nInscripcion = circuito.getnInscripcion();
        this.participante = participante;
        this.valorInscripcion = valorInscripcion;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getValorInscripcion() {
        return valorInscripcion;
    }

    public void setValorInscripcion(double valorInscripcion) {
        this.valorInscripcion = valorInscripcion;
    }

    public int getnInscripcion() {
        return nInscripcion;
    }

    public void setnInscripcion(int nInscripcion) {
        this.nInscripcion = nInscripcion;
    }

    @Override
    public String toString() {
        return "Inscripcion: " +
                " \n Numero de Inscripcion=" + nInscripcion +
                ", \n circuito=" + circuito +
                ", \n participante=" + participante +
                ", \n valorInscripcion=" + valorInscripcion;
    }
}
