package com.MELI;

import com.MELI.models.Cliente;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Set<Cliente> clientes = new HashSet<>();
        Cliente sofia = new Cliente("Sofia", "Menichelli", 36327762);
        Cliente olivia = new Cliente("Olivia", "Perez", 42341231);
        Cliente santino = new Cliente("Santino", "Pompei", 65476523);
        clientes.add(sofia);
        clientes.add(olivia);
        clientes.add(santino);


        System.out.println("-------------------Lista de Clientes-------------------");
        clientes.forEach(System.out::println);

        System.out.println("-------------------Borramos un cliente e imprimimos la Lista de Clientes-------------------");
        clientes.remove(clientes.stream().filter(x -> x.getDNI() == 36327762));

        System.out.println("-------------------Lista de Clientes-------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de DNI para buscar al cliente");
        int DNI = scanner.nextInt();
        System.out.println(DNI);

        Cliente clienteBuscado = clientes.stream().filter(x -> x.getDNI() == DNI).findFirst().orElse(null);

        System.out.println(clienteBuscado);

        if (clienteBuscado == null) {
            System.out.println("El cliente no existe en la Base de Datos");
        } else {
            System.out.println(clienteBuscado.toString());
        }


    }
}
