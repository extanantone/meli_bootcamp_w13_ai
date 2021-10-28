package com.Meli.Supermercado;

import com.Meli.Supermercado.Entity.Cliente;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainSupermercado {

    public static void main(String[] args) {
        Cliente vanesa = new Cliente(36220711, "Vanesa", "Garro");
        Cliente martin = new Cliente(35894068, "Martin", "Paulucci");
        Cliente andres = new Cliente(86049853, "Andres", "Paulucci");

        List<Cliente> clientes = new LinkedList<>();
        clientes.add(vanesa);
        clientes.add(martin);
        clientes.add(andres);

        System.out.println("-------Listado de Clientes -------");
        clientes.stream().forEach(System.out::println);

        clientes.remove(2);
        System.out.println("-------Listado de Clientes (Elinado index 2)-------");
        clientes.stream().forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Ingrese DNI del Cliente");
        long dni = 0;
        while (dni<=0) {
            if(scanner.hasNextLong()){
                dni = scanner.nextLong();
                if(dni<=0){
                    System.err.println("DNI inválido.");
                    dni = 0;
                }
            }
            else{
                System.err.println("DNI inválido.");
                dni = 0;
            }
        }
        final Long dniC = dni;
        List result = clientes.stream().filter(x->x.getDni().compareTo(dniC)==0).collect(Collectors.toList());
        if(result.size()>0)
            System.out.println(result.get(0).toString());
        else
            System.out.println("Cliente no encontrado");

        System.out.println("Adios");

    }
}
