package ejericiciopractico.integrador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Map<String,Cliente> collecionClientes = new HashMap<>();

        Cliente uno = new Cliente("12345","Jose","Sanchez");
        Cliente dos = new Cliente("12346","Pedro","Sanchez");
        Cliente tres = new Cliente("12347","Ricardo","Sanchez");

        collecionClientes.put(uno.getDni(),uno);
        collecionClientes.put(dos.getDni(),dos);
        collecionClientes.put(tres.getDni(),tres);

        // mostrar clientes
       mostrarClientes(collecionClientes);

       // elimino cliente
        removerCliente(collecionClientes,"12345");

        // menu pedir dni cliente a consultar
        consultarCliente(collecionClientes);

        // crear factura integrador parte 2

        Item cosa1 = new Item("1","panelas",2,200.0);
        Factura fact1 = new Factura(uno, List.of(cosa1));


    }

    private static void consultarCliente(Map<String, Cliente> collecionClientes) {
        Scanner scan = new Scanner(System.in);
        System.out.println("ingrese el dni del cliente a consultar:");
        String dni = scan.nextLine();
        if(collecionClientes.containsKey(dni))
            System.out.println(collecionClientes.get(dni));
        else
            System.out.println("El cliente no existe en el sistema");
    }

    public static void mostrarClientes(Map<String,Cliente> clientes){
        System.out.println("los clientes actuales son: ");
        for(Map.Entry<String,Cliente> dato:clientes.entrySet())
        {
            System.out.println(dato.getValue());
        }
    }

    public static void removerCliente(Map<String,Cliente> clientes, String dni){
        clientes.remove(dni);
    }
}
