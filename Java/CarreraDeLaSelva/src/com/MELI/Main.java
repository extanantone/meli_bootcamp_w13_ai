package com.MELI;

import com.MELI.controller.MenuController;

public class Main {

    public static void main(String[] args) {
        MenuController menu = new MenuController();
        int seleccion = 6;
        do{
            seleccion = menu.menuPrincipal();
            menu.accionSeleccion(seleccion);
        }while (seleccion!=6);
        System.out.println();
        System.out.println("Adiós!!!");
    }
}
