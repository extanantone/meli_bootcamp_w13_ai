package com.ejerciciosIntegradores.Integrador1.SaveTheRopa;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>>  diccionario = new HashMap<>();
    private Integer contador=0;


    public Integer guardarPendas(List<Prenda> listaDePrenda){

        this.contador++;

        diccionario.put(contador,listaDePrenda);

        return contador;

    }

    public void mostrarPrendas(){

        for (Map.Entry<Integer,List<Prenda> > gurdaropa: diccionario.entrySet()) {

            String prendas ="";
            for (Prenda prenda: gurdaropa.getValue()) {
                prendas = prendas + prenda.toString();
            }

            System.out.println("Identificador es "+gurdaropa.getKey()+" Y contiene las prendas "+prendas);
        }

    }

    public List<Prenda> devolverPrendas(Integer numero){

        List<Prenda>  prendas = new ArrayList<>();
        for (Map.Entry<Integer,List<Prenda> > gurdaropa: diccionario.entrySet()){

            if(gurdaropa.getKey()==numero){
                prendas= gurdaropa.getValue();
            }
        }
        return prendas;
    }
}
