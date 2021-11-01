package bootcamp.main;

import bootcamp.models.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GestorCliente {

    public static List<Cliente> listaClientes;


    public static void inicializarClientes(){

        listaClientes = new ArrayList<Cliente>();

        Cliente cliente1 = new Cliente (39879820,"Pablo","Guayta");
        Cliente cliente2 = new Cliente (39888222,"Rodrigo","Dimare");
        Cliente cliente3 = new Cliente (33222111,"Facundo","Lopez");

        //listaClientes.add(cliente1);
        //listaClientes.add(cliente2);
        //listaClientes.add(cliente3);
    }

    public static void agregarCliente(Cliente c){
        listaClientes.add(c);
    }

    public static void eliminarClientePorDni (Integer dni){

        List<Cliente> clientesAEliminar = new ArrayList<Cliente>();
        clientesAEliminar = listaClientes.stream().filter(x -> x.getDni() == dni).collect(Collectors.toList());
        listaClientes.removeAll(clientesAEliminar);

    }

    public static Cliente obtenerDetalleCliente(Integer dni){

        return listaClientes.stream().filter(x -> x.getDni() == dni).findFirst().orElse(null);

    }

    public static void mostrarTodosLosClientes(){

        listaClientes.stream().forEach(System.out::println);

    }

    public static void crearCliente(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese dni del cliente nuevo");

        int dni = scanner.nextInt();

        System.out.println("Ingrese nombre");

        String nombre = scanner.next();

        System.out.println("Ingrese apellido");

        String apellido = scanner.next();

        listaClientes.add(new Cliente(dni,nombre,apellido));
    }


}
