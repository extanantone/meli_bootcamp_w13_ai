package com.company.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {
    private Integer id;
    private HashMap<Integer, List<Prenda>> prendas = new HashMap<Integer, List<Prenda>>();


    public GuardarRopa() {
    }

    public GuardarRopa(Integer id, HashMap<Integer, List<Prenda>> prendas) {
        this.id = id;
        this.prendas = prendas;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HashMap<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(HashMap<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    @Override
    public String toString() {
        return "GuardarRopa{" +
                "id=" + id +
                ", prendas=" + prendas +
                '}';
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        this.prendas.put(id, listaDePrenda);
        Integer llave = id;
        id++;
        return llave;
    }

    public void mostrarPrendas() {
        for(Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            System.out.println("La llave es: " + entry.getKey());
            for(Prenda prenda : entry.getValue()) {
                System.out.println(prenda.toString());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {

    }


}
