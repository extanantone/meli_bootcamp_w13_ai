package C4.ejercicioIntegradores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion = 0;
        boolean clienteEncontrado = false;
        int entradaDni;

        Cliente clienteUno = new Cliente(123,"Mario","Duarte");
        Cliente clienteDos = new Cliente(223,"Pedro","Picapiedra");
        Cliente clienteTres = new Cliente(323,"Luisa","Perez");

        //Item itemUno = new Item(1,"Arroz")
        List<Cliente> listaClientes = new ArrayList<>();

        listaClientes.add(clienteUno);
        listaClientes.add(clienteDos);
        listaClientes.add(clienteTres);

        //Imprimir clientes



        do{
            menu();
            Scanner entrada = new Scanner(System.in);
            opcion = entrada.nextInt();
            clienteEncontrado = false;
            switch (opcion){
                case 1:
                    System.out.println("---Lista de Clientes---");
                    listaClientes.stream().map(Cliente::toString).forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Ingrese el dni del cliente");
                    entradaDni = entrada.nextInt();
                    Cliente newCliente = buscarCliente(listaClientes, entradaDni);

                    if (newCliente != null){
                        listaClientes.remove(newCliente);
                        System.out.println("Cliente eliminado");
                    }
                    else{
                        System.out.println("Cliente no encontrado");
                    }

                    break;
                case 3:
                    System.out.println("Ingrese el dni del cliente");
                    entradaDni = entrada.nextInt();
                    Cliente clienteBusqueda = buscarCliente(listaClientes, entradaDni);

                    if (clienteBusqueda != null){
                        System.out.println("Cliente encontrado");
                        System.out.println(clienteBusqueda);
                    }
                    else {
                        System.out.println("Cliente no encontrado");
                    }
                    break;
            }

        }while(opcion != 5);

    }

    private static Cliente buscarCliente(List<Cliente> listaClientes, int idCliente) {
        for (Cliente c: listaClientes) {
            if (c.getDni() == idCliente){
                return c;
            }
        }
        return null;
    }

    private static void menu() {
        System.out.println("----Menu----\n");
        System.out.println("1. Listar los clientes");
        System.out.println("2. Eliminar un cliente");
        System.out.println("3. Buscar cliente");
        System.out.println("4. Crear factura");
        System.out.println("5. Salir");
    }



}
