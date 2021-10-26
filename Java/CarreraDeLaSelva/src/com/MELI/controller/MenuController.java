package com.MELI.controller;

import com.MELI.Service.Service;

import java.util.Scanner;

public class MenuController {

    public int menuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        int seleccion = 0;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("------------MENU PRINCIPAL------------");
            System.out.println();
            System.out.println("Seleccione una opción ingresando el número correspondiente");
            System.out.println();
            System.out.println("1) Ingresar Circuito");
            System.out.println("2) Inscribir Participante");
            System.out.println("3) Mostrar Inscriptos de una categoría");
            System.out.println("4) Desinscribir participante");
            System.out.println("5) Determinar monto de inscripción");
            System.out.println("6) Salir");

            while (!scanner.hasNextInt()) {
                System.out.println();
                System.err.println("Opción incorrecta!");
                scanner.next();
            }
            seleccion = scanner.nextInt();
        } while (seleccion <= 0);
        return seleccion;
    }

    public void accionSeleccion(int seleccion){
        Service service = new Service();
        switch (seleccion){
            case 1: service.solicitarDatosCircuito();
                    break;
            case 2: service.solicitarDatosParticipante();
                    break;
            case 3: service.mostrarInscriptos();
                    break;
            case 4: service.desinscribir();
                    break;
            case 5: service.determinarMonto();
                    break;
            case 6: break;
        }
    }
}
