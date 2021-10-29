package com.Meli.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int nro;
    private HashMap<Integer, List<Prenda>> prendas;

    public GuardaRopa(){
        nro = 0;
        prendas = new HashMap<>();
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public HashMap<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(HashMap<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Integer guardarPrenda(List<Prenda> listaPrenda){
        nro += 1;
        prendas.put(nro,listaPrenda);
        return this.nro;
    }

    public void mostrarPrendas(){
        System.out.println("Prendas en GuardaRopa : ");
        for(Map.Entry<Integer, List<Prenda>> elemento: this.getPrendas().entrySet()){

            System.out.print(elemento.getKey()+" ) ");
            elemento.getValue().stream().forEach(System.out::println);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){

        List<Prenda> lstPrenda = new ArrayList<>();
        for(Map.Entry<Integer, List<Prenda>> elemento: this.getPrendas().entrySet()){
            if(elemento.getKey()==numero){
                lstPrenda=elemento.getValue();
                this.getPrendas().remove(numero);
            }

        }
        return lstPrenda;
    }


}
