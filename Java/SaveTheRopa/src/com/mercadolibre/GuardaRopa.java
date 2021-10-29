package com.mercadolibre;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> guardaRopas;
    private Integer contador;

    public Map<Integer, List<Prenda>> getGuardaRopas() {
        return guardaRopas;
    }

    public void setGuardaRopas(Map<Integer, List<Prenda>> guardaRopas) {
        this.guardaRopas = guardaRopas;
    }


    public Set<Integer> guardarPrendas(List<Prenda>listaDePrenda){
        guardaRopas.put(this.contador,listaDePrenda);
        return guardaRopas.keySet();
    }

    public void mostrarPrendas(){
        guardaRopas.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return guardaRopas.get(numero);
    }


    @Override
    public String toString() {
        return "GuardaRopa{" +
                "guardaRopas=" + guardaRopas +
                ", contador=" + contador +
                '}';
    }

}
