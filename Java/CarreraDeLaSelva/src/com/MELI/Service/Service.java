package com.MELI.Service;

import com.MELI.entity.Circuito;
import com.MELI.entity.Inscripcion;
import com.MELI.helper.Helper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private HashMap<Integer, Circuito>listaCircuito = new HashMap<>();
    private List<Inscripcion> listaInscripcion = new LinkedList<>();

    public Service(){}

    public void solicitarDatosCircuito(){
        Scanner scanner = new Scanner(System.in);
        Circuito circ = new Circuito();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("------------Carga de Circuito------------");
        System.out.println();
        System.out.println("Ingrese Nombre del Circuito");
        String nombre = scanner.next();
        while (Helper.existeCircuito(listaCircuito,nombre)) {
            System.out.println();
            System.err.println("Nombre de circuito existente. Ingrese otro nombre.");
            nombre = scanner.next();
        }
        circ.setNombre(nombre);

        System.out.println();
        System.out.println("Ingrese kilometros del Circuito (Debe ser entero positivo mayor que cero)");
        int valor = 0;
        while (valor<=0) {
            if(scanner.hasNextInt()){
                valor = scanner.nextInt();
                if(valor<=0){
                    System.err.println("Los kilometros deben ser número entero mayor que cero.");
                    valor = 0;
                }
            }
            else{
                System.err.println("Debe ingresar un número entero mayor que cero.");
                valor = 0;
            }
        }
        circ.setKilometros(valor);

        System.out.println();
        System.out.println("Ingrese costo de inscripción del Circuito para mayores de 18");
        double costoMay = -1.0;
        while (costoMay<0) {
            if(scanner.hasNextDouble()){
                costoMay = scanner.nextInt();
                if(costoMay<=0){
                    System.err.println("El costo de inscripción para mayores no puede ser menor que cero.");
                    costoMay = -1.0;
                }
            }
            else{
                System.err.println("Debe ingresar un número entero mayor que cero.");
                costoMay = -1.0;
            }
        }
        circ.setCostoMayor(costoMay);

        System.out.println();
        System.out.println("Ingrese costo de inscripción del Circuito para menores de 18");
        double costoMen = -1.0;
        while (costoMen<0) {
            if(scanner.hasNextDouble()){
                costoMen = scanner.nextInt();
                if(costoMen<0){
                    System.err.println("El costo de inscripción para mayores no puede ser menor que cero.");
                    costoMen = -1.0;
                }
            }
            else{
                System.err.println("Debe ingresar un número entero mayor que cero.");
                costoMen = -1.0;
            }
        }
        circ.setCostoMenor(costoMen);

    }

    public void solicitarDatosParticipante(){

    }

    public void mostrarInscriptos(){

    }

    public void desinscribir(){

    }

    public void determinarMonto(){

    }
}
