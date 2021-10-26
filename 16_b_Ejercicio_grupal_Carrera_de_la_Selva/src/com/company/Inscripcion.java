package com.company;

public class Inscripcion {

    private Person p; // participante
    private double precio; // monto abonado por participante
    private boolean confirmado; // variable que definira si un inscripto esta dado de alta o no
    private int nroInscripto;

    public Inscripcion(Person p, double precio, boolean confirmado, int nroInscripto) {
        this.p = p;
        this.precio = precio;
        this.confirmado = confirmado;
        this.nroInscripto = nroInscripto;
    }

    public int getNroInscripto() {
        return nroInscripto;
    }

    public void setNroInscripto(int nroInscripto) {
        this.nroInscripto = nroInscripto;
    }


    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }
}
