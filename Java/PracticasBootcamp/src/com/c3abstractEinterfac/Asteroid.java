package com.c3abstractEinterfac;

import java.util.ArrayList;
import java.util.List;

public class Asteroid {

    public static void main(String[] args) {

        List<Persona> participante = new ArrayList<>();

        Flota flota1 = new Flota("Estelar");

        NaveSimple naveSimple1 = new NaveSimple("Iq32",5,7,0);
        NaveSimple naveSimple2 = new NaveSimple("Iq31",8,2,0);
        NaveSimple naveSimple3 = new NaveSimple("Iq30",7,1,0);
        NaveSimple naveSimple4 = new NaveSimple("Iq54",2,1,0);


        flota1.agregarNaveSimple(naveSimple1);
        flota1.agregarNaveSimple(naveSimple2);
        flota1.agregarNaveSimple(naveSimple3);

        flota1.print();
        naveSimple1.print();

        Persona p1 = new Persona("danut");
        Persona p2 = new Persona("len");

        p1.agregarNaveSimpleOflota(flota1);
        p2.agregarNaveSimpleOflota(naveSimple4);

        participante.add(p1);
        participante.add(p2);

        Asteroid as = new Asteroid();
        int x = 7;
        int y = 3;
        as.asignarpuno(participante,x,y);


    }

    public void asignarpuno(List<Persona> lisP, int x , int y){

        for (Icordenadas cor: lisP)
        {


        }
    }
}
