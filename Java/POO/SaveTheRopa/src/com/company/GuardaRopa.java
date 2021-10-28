package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> prendas = new HashMap<>();
    private Integer contador = 0;

    public HashMap<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(HashMap<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        this.prendas.put(this.contador, listaDePrenda);
        Integer llave = this.contador;
        this.contador++;
        return llave;
    }

    public void mostrarPrendas() {
        System.out.println("Todas las prendas guardadas son:");
        for(Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            System.out.println("\tLa llave es: " + entry.getKey());
            for(Prenda prenda : entry.getValue()) {
                System.out.println("\t\t" + prenda.getMarca() + " - " + prenda.getModelo());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendasDevueltas = prendas.get(numero);
        prendas.remove(numero);
        return prendasDevueltas;
    }
}
