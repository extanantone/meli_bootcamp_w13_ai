package bootcamp_jdmichiel;

import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Categoria circuito_chico = new Categoria("Circuito chico",2,1300,1500);
        Categoria circuito_medio = new Categoria("Circuito medio",5,2000,2300);
        Categoria circuito_avanzado = new Categoria("Circuito avanzado",10,-1,2800);

        Persona p1 = new Persona(334343, "Raul", "Lopez", 20, 123, 1122, "A(-)");
        Persona p2 = new Persona(434343, "Luis", "Rosso", 18, 456, 2233, "A(+)");
        Persona p3 = new Persona(545454, "Pedro", "Perez", 14, 789, 3344, "A(+)");
        Persona p4 = new Persona(121212, "Juan", "Quintana", 17, 321, 4455, "O(+)");
        Persona p5 = new Persona(767676, "Pablo", "Eusebio", 12, 654, 5566, "A(-)");
        Persona p6 = new Persona(989898, "Lio", "Messi", 18, 987, 6677, "A(-)");

        circuito_medio.setParticipante(p1.getDni(),p1);
        circuito_medio.setParticipante(p2.getDni(),p2);
        circuito_chico.setParticipante(p3.getDni(),p3);
        circuito_chico.setParticipante(p4.getDni(),p4);
        circuito_avanzado.setParticipante(p5.getDni(),p5);
        circuito_avanzado.setParticipante(p6.getDni(),p6);

        for(Map.Entry<Integer,Persona> p : circuito_chico.getParticipantes().entrySet()){
            System.out.println("Participante " + p.getValue().getNombre() +" "+ p.getValue().getApellido());
        }

        circuito_chico.deleteParticipante(52345);

        for(Map.Entry<Integer,Persona> p : circuito_chico.getParticipantes().entrySet()){
            System.out.println("Participante " + p.getValue().getNombre() +" "+ p.getValue().getApellido());
        }
    }
}