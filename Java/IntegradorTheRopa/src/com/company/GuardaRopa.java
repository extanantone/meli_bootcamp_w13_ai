package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer con;
    private Map<Integer, List<Prenda>> dic;

    public GuardaRopa() {
        this.con = 0;
        this.dic = new HashMap<>();
    }


    public Integer guardaPrendas(List<Prenda> guardaPrenda){
        Integer id = con;
        dic.put(id,guardaPrenda);
        id++;
        return id;
    }

    public void mostrarPrenda(){
        for (Integer id: dic.keySet()){
            List<Prenda> listaPrendas = dic.get(id);
            System.out.println(listaPrendas);
        }
    }


    public List<Prenda> devolverPrendas(Integer numero){

        List<Prenda> prenda = dic.remove(numero);
        return prenda;
    }


    public Map<Integer, List<Prenda>> getDic() {
        return dic;
    }
}
