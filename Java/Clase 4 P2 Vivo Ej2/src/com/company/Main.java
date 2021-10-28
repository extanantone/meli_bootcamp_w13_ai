package com.company;

public class Main {

    public static void main(String[] args) {
	    Carrera carrera = new Carrera(7, 5000, "Carreron", 5);
	    carrera.darDeAltaAuto(70.7, 3.4, 58, "gd141sd");
	    carrera.darDeAltaAuto(80.7, 1.4, 23, "21tsdf");
	    carrera.darDeAltaAuto(10.7, 0.05, 170, "54urth");
	    carrera.darDeAltaMoto(60.2, 8.4, 5.4, "j13lasd");
	    carrera.darDeAltaMoto(41.6, 3.4, 60, "j091fas");

	    carrera.correr();
	    carrera.socorrerAuto("54urth");
	    carrera.socorrerMoto("j091fas");
    }
}
