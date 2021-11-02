package com.ejerciciosIntegradores.Integrador1.SaveTheRopa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

       List<Prenda>lisPrendas = new ArrayList<>(Arrays.asList( new pantalon("X","f","leg")
               ,new Camisa("F","g","sueter")
       ,new pantalon("y","f","f")));

        List<Prenda>lisPrendas2 = new ArrayList<>(Arrays.asList( new Camisa("T","q","Comisa")
                ,new pantalon("y","f","f")));


        GuardaRopa guardaRopa1 = new GuardaRopa();

       Integer llave = guardaRopa1.guardarPendas(lisPrendas);
        Integer llave2 = guardaRopa1.guardarPendas(lisPrendas2);

       guardaRopa1.mostrarPrendas();


      List<Prenda> prendas=  guardaRopa1.devolverPrendas(llave);
      prendas.forEach(prenda-> System.out.println("La prenda devuelta es"+ prenda.toString()));
    }
}
