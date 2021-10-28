package Supermercado;

// Sin BONUS

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Crear lista, agregar Clientes y mostrar
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(new Cliente(387, "Jhon", "Doe"));
        listaClientes.add(new Cliente(40777475, "Jhin", "Une"));
        listaClientes.add(new Cliente(50777475, "Jhen", "Cue"));

        System.out.println(Arrays.toString(listaClientes.toArray()));
        // Quitar un Cliente y mostrar
        listaClientes.remove(1);
        System.out.println(Arrays.toString(listaClientes.toArray()));

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
        ArrayList<Item> listItem = new ArrayList<>();
        listItem.add(new Item(12312,"Pepsi",300,3));
        listItem.add(new Item(12313,"Sprite",350,2));
        Factura factura = new Factura(cliente4, listaClientes, listItem);
        System.out.println(factura);
        System.out.println(listaClientes);
    }
}
