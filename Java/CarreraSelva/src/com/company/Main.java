package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Persona> listaPersonas = new ArrayList<Persona>();

        listaPersonas.add(new Persona(1, "Hola", "Crayola", 10, "11111111", "12121212", "0-", 0));
        listaPersonas.add(new Persona(1, "Holaa", "Crayol", 20, "11111111", "12121212", "0-", 0));
        listaPersonas.add(new Persona(1, "Hol", "Crayolaa", 30, "11111111", "12121212", "0-", 0));
        listaPersonas.add(new Persona(1, "Holi", "Crayol", 40, "11111111", "12121212", "0-", 0));

        List<Persona> chico = new LinkedList<Persona>();
        List<Persona> medio = new LinkedList<Persona>();
        List<Persona> avanzado = new LinkedList<Persona>();



        for(int i = 0; i < listaPersonas.size(); i++) {
            if(i == 0 || i == 2) {
                if (listaPersonas.get(i).edad > 17) {
                    avanzado.add(listaPersonas.get(i));
                    System.out.println(listaPersonas.get(i).nombre + " debe pagar 2800.");
                } else {
                    System.out.println(listaPersonas.get(i).nombre + " no es mayor de edad.");
                }
            } else {
                if(i == 1) {
                    int valor_pagar = 2300;
                    if (listaPersonas.get(i).edad < 18) {
                        valor_pagar = 2000;
                    }
                    medio.add((listaPersonas.get(i)));
                    System.out.println((listaPersonas.get(i).nombre + " deber pagar " + valor_pagar));
                } else {
                    int valor_pagar = 1500;
                    if (listaPersonas.get(i).edad < 18) {
                        valor_pagar = 1300;
                    }
                    chico.add((listaPersonas.get(i)));
                    System.out.println((listaPersonas.get(i).nombre + " deber pagar " + valor_pagar));
                }
            }
        }
    }
}
