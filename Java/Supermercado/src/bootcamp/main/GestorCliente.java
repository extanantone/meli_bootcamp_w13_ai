package bootcamp.main;

import bootcamp.models.Cliente;
import bootcamp.models.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestorCliente {

    public static List<Cliente> listaClientes;


    public static void inicializarClientes(){

        listaClientes = new ArrayList<Cliente>();

        Cliente cliente1 = new Cliente (39879820,"Pablo","Guayta");
        Cliente cliente2 = new Cliente (39888222,"Rodrigo","Dimare");
        Cliente cliente3 = new Cliente (33222111,"Facundo","Lopez");

    }

    public static void agregarCliente(Cliente c){
        listaClientes.add(c);
    }

    public static void eliminarClientePorDni (Integer dni){

        List<Cliente> clientesAEliminar = new ArrayList<Cliente>();
        clientesAEliminar = listaClientes.stream().filter(x -> x.getDni() == dni).collect(Collectors.toList());
        listaClientes.removeAll(clientesAEliminar);

    }

    public static Optional<Cliente> obtenerDetalleCliente(Integer dni){

        return listaClientes.stream().filter(x -> x.getDni() == dni).findFirst();

    }

    public static void mostrarTodosLosClientes(){

        listaClientes.stream().forEach(System.out::println);

    }


}
