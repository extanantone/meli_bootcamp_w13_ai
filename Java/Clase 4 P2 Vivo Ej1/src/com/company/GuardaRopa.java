package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Map<Integer, List<Prenda>> prendasMap;
    int id;

    public GuardaRopa() {
        id = 0;
        prendasMap = new HashMap<>();
    }

    public Integer guardaRopa(List<Prenda> prendas){
        prendasMap.put(id, prendas);
        return id++;
    }

    public void mostrarPrendas(){
        if (prendasMap.size() > 0) {
            for (Integer key : prendasMap.keySet()) {
                prendasMap.get(key).forEach(p -> System.out.println("Id " + key + " Prenda : " + p.toString()));
            }
        }
        else
            System.out.println("No hay prendas guardadas");

    }

    public List<Prenda> devolverPrendas(int key){
        return prendasMap.remove(key);
    }
}
