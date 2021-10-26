package com.company;

import java.util.*;

public class Categorias {
    private static int codigo=0;
    private int codcar;
    private String tipo;
    private Double valorMayorEdad;
    private Double valorMenorEdad;


    public Categorias(String tipo, Double valorMayorEdad, Double valorMenorEdad) {
        codigo++;
        this.codcar = codigo;
        this.tipo = tipo;
        this.valorMayorEdad = valorMayorEdad;
        this.valorMenorEdad = valorMenorEdad;
    }

    public int getCodcar() {
        return codcar;
    }

    public void setCodcar(int codcar) {
        this.codcar = codcar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValorMayorEdad() {
        return valorMayorEdad;
    }

    public void setValorMayorEdad(Double valorMayorEdad) {
        this.valorMayorEdad = valorMayorEdad;
    }

    public Double getValorMenorEdad() {
        return valorMenorEdad;
    }

    public void setValorMenorEdad(Double valorMenorEdad) {
        this.valorMenorEdad = valorMenorEdad;
    }
}
