package com.company;

public class PersonalTecnico extends Personal implements Tecnico{
    public PersonalTecnico(String nombre, String dni, String legajo, String ocupacion) {
        super(nombre, dni, legajo, ocupacion);
    }

    @Override
    void fichar() {
        System.out.println("El personal técnico está fichando");
    }

    @Override
    public void RevisarComputadoras() {
        System.out.println("El personal técnico está revisando las computadores");
    }

    @Override
    public void ArreglarComputadoras() {
        System.out.println("El personal técnico está arreglando las computadores");
    }

    @Override
    public void ControlarRedes() {
        System.out.println("El personal técnico está controlando las redes");
    }

    @Override
    public void RealizarSetup() {
        System.out.println("El personal técnico está realizando el setup");
    }
}
