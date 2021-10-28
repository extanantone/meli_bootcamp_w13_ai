import Factura.Cliente;

import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
       Cliente david = new Cliente("1122121", "david", "orejuela");
       Cliente camilo = new Cliente("2213131", "camilo", "perez");
       Cliente jorge = new Cliente("1133421", "jorge", "ramirez");

       HashMap<String, Cliente> clienteList = new HashMap<>();
       clienteList.put(david.getDni(), david);
       clienteList.put(camilo.getDni(), camilo);
       clienteList.put(jorge.getDni(), jorge);

       System.out.println("Mostrar datos de los clientes");
       clienteList.forEach((key, value) -> System.out.println(value));

       System.out.println("Eliminar uno de los clientes e imprimir los restantes");
       clienteList.remove(david.getDni());
       clienteList.forEach((key, value) -> System.out.println(value));

       System.out.println("Buscar cliente");
       Scanner keyboard = new Scanner(System.in);
       System.out.println("Ingrese el dni");
       String searchDni = keyboard.next();
       System.out.println(clienteList.get(searchDni));


    }
}
