package com.company;

import com.company.model.Cliente;
import com.company.model.Factura;
import com.company.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Cliente azul = new Cliente(34534534L, "Azul", "Smith");
        Cliente juan = new Cliente(4566567L, "Juan", "Pérez");
        Cliente facundo = new Cliente(21334556L, "Facundo", "Pérez");

        List<Cliente> clientes = new ArrayList();

        clientes.add(azul);
        clientes.add(juan);
        clientes.add(facundo);

        for (Cliente cliente :clientes) {
            System.out.println(cliente.toString());
        }

        clientes.remove(juan);

        System.out.println("\n");

        for (Cliente cliente :clientes) {
            System.out.println(cliente.toString());
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("Ingresar DNI: ");

        Long dniABuscar = scan.nextLong();

        scan.close();

        boolean encontrado = false;

        for (Cliente cliente :clientes) {
            if (!(cliente.getDni().equals(dniABuscar))) continue;
            System.out.println(cliente.toString());
            encontrado = true;
            break;
        }

        if (!encontrado) {
            System.out.println("\nNo se ha encontrado al cliente");
        }

    }
}
