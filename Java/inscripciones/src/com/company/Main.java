package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Persona> inscripcionesCircuitoChico = new ArrayList<Persona>();
        ArrayList<Persona> inscripcionesCircuitoMedio = new ArrayList<Persona>();
        ArrayList<Persona> inscripcionesCircuitoAvanzado = new ArrayList<Persona>();

        Persona juan = new Persona();
	    //Hacer tres listas
        //Personas: dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo.

        //Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.
        //Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.
        //Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800

        //Inscribir a un nuevo participante en una categoría. (Tener en cuenta que cada categoría tiene una lista de inscriptos diferente).
        //Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
        //Desinscribir a un participante de una categoría.
        //Determinar el monto que deberá abonar cada participante al inscribirse. Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene 21 años, el monto a abonar es de $1500.
    }
}
