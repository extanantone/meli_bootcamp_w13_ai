package Supermercado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Crear lista, agregar Clientes y mostrar
        ListaClientes listaClientes = new ListaClientes();
        listaClientes.alta(new Cliente(387, "Jhon", "Doe"));
        listaClientes.alta(new Cliente(40777475, "Jhin", "Une"));
        listaClientes.alta(new Cliente(50777475, "Jhen", "Cue"));

        System.out.println(listaClientes);
        // Quitar un Cliente y mostrar
        listaClientes.baja(40777475);
        System.out.println(listaClientes);

        // Solicitar dni por consola
       /* Scanner sc = new Scanner(System.in);
        int dni = sc.nextInt();
        Cliente[] search = listaClientes.stream().filter(o -> o.getDni() == dni).toArray(Cliente[]::new);
        if (search.length < 1) {
            System.out.println("DNI no encontrado");
        } else {
            System.out.println("Cliente encontrado: " + search[0]);
        }*/

        //crear nueva factura
        Cliente cliente4 = new Cliente(12, "Jhun", "Tre");
        Factura factura = new Factura(cliente4, listaClientes.getListaClientes());
        factura.alta(new Item(12312,"Pepsi",300,3));
        factura.alta(new Item(12313,"Sprite",350,2));
        System.out.println(factura);
        System.out.println(listaClientes);
    }
}
