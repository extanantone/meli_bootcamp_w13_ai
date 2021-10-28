package com.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private int cont=0;
    private Map<Integer,List<Prenda>> prendas;

    public GuardaRopa(){
        prendas = new HashMap<>();
    }
    

    public int guardarPrenda(List<Prenda> prendasSave){
        int current = cont;
        cont++;
        prendas.put(current, prendasSave);
        return current;
    }

    public void mostrarPrendas(){
        for(int key:prendas.keySet()){
            System.out.println("Id: "+key);
            for(Prenda prenda: prendas.get(key)){
                System.out.println("Marca: "+prenda.getMarca());
                System.out.println("Modelo: "+prenda.getModelo());
            }
            System.out.println("------------------------------------------");
        }
    }

    public List<Prenda> devolvePrendas(int id){
        return prendas.remove(id);
    }

    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();


        int id =guardaRopa.guardarPrenda(List.of(new Prenda("Adidas", "test")));
        int id2 =guardaRopa.guardarPrenda(List.of(new Prenda("Nike", "test2")));

        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolvePrendas(id));
        System.out.println(guardaRopa.devolvePrendas(id2));

        guardaRopa.mostrarPrendas();
    }

}
