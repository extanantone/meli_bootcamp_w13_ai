package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("27213134", "Juan", "Tuliano"));
        clientes.add(new Cliente("34213512", "Rosa", "Galan"));
        clientes.add(new Cliente("38123942", "Veronica", "Pitinari"));

        System.out.println("Lista de clientes original");
        clientes.forEach(System.out::println);

        System.out.println("\n Lista de clientes sin rosa");
        clientes.remove(1);
        clientes.forEach(System.out::println);

        Scanner sc = new Scanner(System.in);
        System.out.println("\n Ingrese el dni del cliente a buscar (sin puntos) : ");
        String dni = sc.next();

        List<Cliente> clientesEncontrados = clientes.stream().filter(c -> c.getDni().equals(dni)).collect(Collectors.toList());
        if(clientesEncontrados.size() > 0){
            System.out.println("Se encontraron los siguientes clientes con ese DNI ");
            clientesEncontrados.forEach(System.out::println);
        }
        else
            System.out.println("No se encontró ningún cliente con el dni provisto");
    }
}
