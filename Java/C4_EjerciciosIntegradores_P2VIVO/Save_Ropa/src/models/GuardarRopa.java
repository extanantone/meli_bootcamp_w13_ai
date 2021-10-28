package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {
    Map<Integer, List<Prenda>> contenidoGuardarropa;
    Integer id;

    public GuardarRopa() {
        this.id = 0;
        contenidoGuardarropa = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> prendas){
        id++;
        contenidoGuardarropa.put(id,prendas);
        return id;

    }

    public void mostrarPrendas(){
        contenidoGuardarropa.forEach((k,v)-> {
            System.out.println("Las prendas a retirar con el numero "+k+" son:");
                v.forEach((x)-> System.out.println("Marca: "+x.getMarca()+", modelo: "+x.getModelo()+"\\"));
        });
    }

    public void devolverPrendas(Integer id){
        contenidoGuardarropa.remove(id);
    }


}
