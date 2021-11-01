package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de cuidades a registrar: ");
        int cant_ciudades = input.nextInt();
        //Tambien se puede usar ciudades.length y devolveria la cantidad de filas del array, pero como no lo vimos, no lo uso en la practica

	    String[] ciudades = new String[cant_ciudades];
        double[][] temperatura_ciudad = new double[cant_ciudades][cant_ciudades];
        cargarCiudades(ciudades);
        cargarTemperaturaCuidad(ciudades,temperatura_ciudad);
        ciudadConMayorTemperatura(ciudades,temperatura_ciudad);
        ciudadConMenorTemperatura(ciudades,temperatura_ciudad);
    }
    private static void ciudadConMayorTemperatura(String[] ciudades, double[][] temperatura_ciudad) {
        double max = temperatura_ciudad[0][1];
        int pos = 0;
        for(int i = 1; i< temperatura_ciudad.length;i++){
            System.out.println("Temp: " + temperatura_ciudad[i][1] + " > " + max);
            System.out.println("pos: " + pos);
            if(temperatura_ciudad[i][1]>max){
                max = temperatura_ciudad[i][1];
                pos=i;
            }

        }
        System.out.println("La ciudad con mayor temperatura es " + ciudades[pos] + " con " + max + " ºC");
    }

    private static void ciudadConMenorTemperatura(String[] ciudades, double[][] temperatura_ciudad) {
        double min = temperatura_ciudad[0][0];
        int pos = 0;
        for(int i=1; i<temperatura_ciudad.length;i++){
            if(temperatura_ciudad[i][0] < min){
                min = temperatura_ciudad[i][0];
                pos=i;
            }
        }
        System.out.println("La ciudad con menor temperatura es " + ciudades[pos] + " con " + min + " ºC");
    }

    private static void cargarTemperaturaCuidad(String ciudades[], double[][] temperatura_ciudad) {
        Scanner input = new Scanner(System.in);
        for(int i=0; i<ciudades.length;i++) {
            System.out.println("Ingrese la temperatura minima para la ciudad: " + ciudades[i]);
            int tempMinima = input.nextInt();
            System.out.println("Ingrese la temperatura maxima para la ciudad: " + ciudades[i]);
            int tempMaxima = input.nextInt();
            temperatura_ciudad[i][0] = tempMinima;
            temperatura_ciudad[i][1] = tempMaxima;
        }

    }

    private static void cargarCiudades(String[] ciudades) {
        int i= 0;
        do{
            Scanner input = new Scanner(System.in);
            System.out.println("Ingrese el nombre de la cuidad: ");
            ciudades[i] = input.nextLine();
            i++;
        } while (i< ciudades.length);
    }
}
