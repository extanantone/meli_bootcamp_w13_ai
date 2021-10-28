package com.company.models;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    int contador;
    Map<Integer, List<Prenda>> closet;

    public GuardaRopa(Map closet) {
        this.contador = 0;
        this.closet = closet;
    }

    public GuardaRopa() {
        this.contador = 0;
        this.closet = new HashMap<>();
    }


    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Map getCloset() {
        return closet;
    }

    public void setCloset(Map closet) {
        this.closet = closet;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        closet.put(this.contador, listaDePrendas);
        return contador++;
    }

    public void mostrarPrendas() {
        this.closet.forEach((id, listaDePrendas) -> {
            System.out.println("Cajón = " + id + "\n");
            listaDePrendas.forEach(prenda -> {
                    System.out.println(prenda.toString());
            });
        });
    }

    public List<Prenda> devolverPrendas(Integer id) {
        return this.closet.remove(id);
    }
}
