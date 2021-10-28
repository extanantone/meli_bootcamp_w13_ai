package com.company;

import com.company.model.Cliente;
import com.company.repository.ClienteImp;
import com.company.repository.FacturaImp;
import com.company.repository.ItemImp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ClienteImp clienteImp = new ClienteImp();
        FacturaImp facturaImp = new FacturaImp();
        ItemImp itemImp = new ItemImp();

        Cliente azul = new Cliente(34534534L, "Azul", "Smith");
        Cliente juan = new Cliente(4566567L, "Juan", "Pérez");
        Cliente facundo = new Cliente(21334556L, "Facundo", "Pérez");

        clienteImp.save(azul);
        clienteImp.mostrarPantalla();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni a buscar");
        Long dniBuscado = teclado.nextLong();
        clienteImp.buscar(dniBuscado);

        System.out.println("Ingrese el dni a buscar para eliminar");
        Long dniBorrado = teclado.nextLong();
        clienteImp.eliminar(dniBorrado);

    }
}
