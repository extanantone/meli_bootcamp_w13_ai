package com.MELI.models;

public class Inscripcion {
    private int numeroInscripcion;
    private Circuito circuito;
    private Participante participante;
    private double valorInscripcion;

    public Inscripcion(int numeroInscripcion, Circuito circuito, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.circuito = participante.getEdad() < 18 && circuito.getTipo() == "Avanzado" ? null : circuito;
        this.participante = participante;
        this.valorInscripcion = participante.getEdad() >= 18 ? circuito.getCostoMayor() : circuito.getCostoMenor();
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
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

    @Override
    public String toString() {
        return
                "numeroInscripcion=" + numeroInscripcion +
                ", circuito=" + circuito +
                ", participante=" + participante +
                ", valorInscripcion=" + valorInscripcion +
                '}';
    }


}
