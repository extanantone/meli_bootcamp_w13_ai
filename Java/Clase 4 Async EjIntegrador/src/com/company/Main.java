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

        Repositorio repositorio = new Repositorio(new ArrayList<>(), clientes);

        System.out.println("Lista de clientes original");
        repositorio.imprimirClientes();

        System.out.println("\n Lista de clientes sin rosa");
        repositorio.clientes.remove(1);
        repositorio.imprimirClientes();

//        Scanner sc = new Scanner(System.in);
//        System.out.println("\n Ingrese el dni del cliente a buscar (sin puntos) : ");
//        String dni = sc.next();
//        repositorio.imprimirClienteBuscado(dni);

        System.out.println("---------------");

        List<Item> items = new ArrayList<>();
        items.add(new Item("3fs01", "Arroz", 3, 43.4));
        items.add(new Item("f12312", "Milanesa", 2, 230.d));
        items.add(new Item("1sd68ss", "Lata de birra", 6, 130.5));
        items.add(new Item("1253ds", "Bolsa de mani", 1, 80.d));
        System.out.println("Total factura : $" + repositorio.agregarFactura(new Factura(new Cliente("2820123", "Damian", "Paez"), items )));
    }
}
