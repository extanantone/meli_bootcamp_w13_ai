package supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente(1233898705L, "Juan", "Lozano"));
        listaClientes.add(new Cliente(1L, "1", "1"));
        listaClientes.add(new Cliente(2L, "2", "2"));
        listaClientes.stream().forEach(System.out::println);
        Scanner in = new Scanner(System.in);
        System.out.println("///////////////////////////////////////////////");
        System.out.println("Ingrese el dni de la persona a borrar");
        Long dniABorrar = in.nextLong();
        boolean flag = listaClientes.removeIf(x -> x.getDni().equals(dniABorrar));
        if (flag) System.out.println("El cliente ha sido borrado correctamente");
        else System.out.println("No se encontró el cliente a borrar");
        System.out.println("///////////////////////////////////////////////");
        System.out.println("Ingrese el dni a buscar");
        Long dniABuscar = in.nextLong();
        //flag = listaClientes.stream().anyMatch(x -> x.getDni().equals(dniABorrar));
        List<Cliente> clientesFiltrados = listaClientes.stream().filter(x -> x.getDni().equals(dniABuscar)).collect(Collectors.toList());
        if (clientesFiltrados.isEmpty()) System.out.println("Cliente no encontrado");
        else {
            System.out.println("Cliente encontrado");
            clientesFiltrados.stream().forEach(System.out::println);
        }
    }
}