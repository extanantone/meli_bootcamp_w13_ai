package com.MELI;

import com.MELI.models.Garaje;
import com.MELI.models.Vehiculo;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Vehiculo> vehiculos= List.of(
            new Vehiculo("Fiesta", "ford", 1000),
            new Vehiculo("Focus", "ford", 1200),
            new Vehiculo("Explorer", "ford", 2500),
            new Vehiculo("Uno", "fiat", 500),
            new Vehiculo("Cronos", "fiat", 1000),
            new Vehiculo("Torino", "fiat", 1250),
            new Vehiculo("Aveo", "chevrolet", 1250),
            new Vehiculo("Spin", "chevrolet", 2500),
            new Vehiculo("Corolla", "Toyota", 1200),
            new Vehiculo("Fortuner", "Toyota", 3000),
            new Vehiculo("Logan", "Renault", 950)
        );

        Garaje garaje = new Garaje(1, vehiculos);

        System.out.println('\n' + "Ordenamiento Precio" + '\n');

        //Ordenar por precio
        vehiculos.stream().sorted((x,y) -> x.compareTo(y)).forEach(System.out::println);


        System.out.println('\n' + "Ordenamiento Por Marca y Precio" + '\n');

        //Ordenar por precio y marca
        vehiculos.stream().sorted((x,y) -> (x.compareTo(y))).sorted((x,y) -> (x.compareToString(y))).forEach(System.out::println);


        System.out.println('\n' + "Vehiculos menor a 1000" + '\n' );
        //Filtrar vehiculos con precio menor o igual a 1000
        vehiculos.stream().filter(x -> x.getCosto() <= 1000).forEach(System.out::println);


        System.out.println('\n' + "Promedio" + '\n' );

        //Promedio Total del precio de todos los vehiculos
        List<?> arrPromedio= vehiculos.stream().map(x -> x.getCosto()).collect(Collectors.toList());
        double suma = vehiculos.stream().mapToDouble(x -> x.getCosto()).sum();

        //Codigo para modificar la salida del promedio
        String pattern = "#.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);


        double promedio = suma / arrPromedio.size();
        String formattedDouble = decimalFormat.format(promedio);

        //Forma reducida de efectuar promedios
        //Double promedio = vehiculos.stream().mapToDouble(Vehiculo::getCosto).average();

        System.out.println('\n' + "El promedio del precio de los vehiculos es: " + formattedDouble);
    }
}
