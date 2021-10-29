package com.MELI;

import com.MELI.models.Cliente;
import com.MELI.models.Factura;
import com.MELI.models.Item;

import java.util.*;

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

        //Items
        List<Item> itemsAFacturar = new ArrayList<>();
        Item cocaCola = new Item("Coca Cola", 2,175.00);
        Item bizcochuelo = new Item("Bizcochuelo", 1,350.00);
        Item ddl = new Item("Dulce De Leche", 2,220.00);
        Item cremaDeLeche = new Item("Crema De Leche", 2,180.00);
        Item merengue = new Item("Merenguitos", 1,280.00);
        Item chocCobertura = new Item("Chocolate Cobertura", 2,185.00);

        itemsAFacturar.add(cremaDeLeche);
        itemsAFacturar.add(cocaCola);
        itemsAFacturar.add(bizcochuelo);
        itemsAFacturar.add(ddl);
        itemsAFacturar.add(merengue);
        itemsAFacturar.add(chocCobertura);

        Cliente cliente = new Cliente();
        if(clientes.stream().filter(x -> x.getDNI() == cliente.getDNI()).findFirst().isPresent()) {
            Factura factura = new Factura(cliente, itemsAFacturar);
        } else {
            clientes.add(cliente);
            Factura factura = new Factura(cliente, itemsAFacturar);
        }

        System.out.println("Se ha creado con exito la factura al cliente: " + factura.getCliente().getNombre() + " ha comprado " + factura.getItems() + " y su valor total es: $" + factura.getTotalCompra());
        System.out.println(factura);

        System.out.println("-------------------Lista de Clientes-------------------");
        clientes.forEach(System.out::println);

        System.out.println("-------------------Borramos un cliente e imprimimos la Lista de Clientes-------------------");
        clientes.remove(clientes.stream().filter(x -> x.getDNI() == 36327762));

        System.out.println("-------------------Lista de Clientes-------------------");

        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de DNI para buscar al cliente");
        int DNI = scanner.nextInt();
        System.out.println(DNI);

        Cliente clienteBuscado = clientes.stream().filter(x -> x.getDNI() == DNI).findFirst().orElse(null);

        if (clienteBuscado == null) {
            System.out.println("El cliente no existe en la Base de Datos");
        } else {
            System.out.println(clienteBuscado.toString());
        }*/




    }
}
