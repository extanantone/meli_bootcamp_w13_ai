package com.MELI;

import com.MELI.models.Circuito;
import com.MELI.models.Inscripcion;
import com.MELI.models.Participante;

import java.util.*;

public class Main {

    private static Circuito circuito;

    public static void main(String[] args) {
	// write your code here

        public String agregarParticipanteAlCircuito(Circuito circuito, Participante participante){
            if(circuito.getTipo() == "Avanzado" && participante.getEdad() < 18){
                return "Este participante no puede participar" + participante;
            } else {
                circuito.addParticipantes(participante);
                return "El participante fue inscripto correctamente" + participante.getNombre() + participante.getApellido();
            }
        }
        Circuito chico = new Circuito("Chico", 2, 1300, 1500);
        Circuito medio = new Circuito("Medio", 5, 2000, 2300);
        Circuito avanzado = new Circuito("Avanzado", 10, 0, 2800);

        Participante p1 = new Participante(32234234, "Vanesa","Garro", 291523749, 30, 293814912, "A+" );
        Participante p2 = new Participante(12312432, "Sofia","Perez", 291523749, 12, 293814912, "0+" );
        Participante p3 = new Participante(42352932, "Sebastian","Gomez", 291523749, 18, 293814912, "A-" );

        Inscripcion inscripcion = new Inscripcion(1, chico, p1);
        Inscripcion inscripcion2 = new Inscripcion(3, medio, p3);
        Inscripcion inscripcion3 = new Inscripcion(4, avanzado, p2);

        Map<Circuito, Participante> inscripcion = new HashMap<>();

        if()
        inscripcion.put(chico, p1);
        inscripcion.put(avanzado, p2);

        System.out.println(chico.getParticipantes());
        System.out.println(inscripcion2);
        System.out.println(inscripcion3);


    }
}
