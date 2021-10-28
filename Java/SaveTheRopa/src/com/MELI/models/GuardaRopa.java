package com.MELI.models;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> guardaRopa = new HashMap<>();
    private Integer contador = 0;

    public GuardaRopa(Map<Integer, List<Prenda>> guardaRopa) {
        this.guardaRopa = guardaRopa;
    }

    public GuardaRopa() {
    }

    public Map<Integer, List<Prenda>> getGuardaRopa() {
        return guardaRopa;
    }

    public void setGuardaRopa(Map<Integer, List<Prenda>> guardaRopa) {
        this.guardaRopa = guardaRopa;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "guardaRopa=" + guardaRopa +
                ", contador=" + contador +
                '}';
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        this.contador++;
        this.guardaRopa.put(contador, listaDePrendas);
        return contador;
    }

    public void mostrarPrendas() {
        for(Map.Entry<Integer, List<Prenda>> prenda: guardaRopa.entrySet()) {
            System.out.println(prenda);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return guardaRopa.get(numero);
    }
}
