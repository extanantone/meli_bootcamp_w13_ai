package com.company;

public class Curriculum implements Imprimible{
    Persona persona;

    public Curriculum(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void Imprimir() {
        System.out.println("\n >Nombre: \n" + persona.getNombre());
        System.out.println(">Habilidades: ");
        persona.getHabilidades().forEach((n)-> System.out.println(n));
    }
}
