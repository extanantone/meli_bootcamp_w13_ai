package bootcamp.main;

import bootcamp.models.Cliente;
import bootcamp.models.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Producto> productosEnStock;

    public static void main(String[] args) {

        GestorProducto.inicializarProductos();
        GestorCliente.inicializarClientes();

        int opcion = -1;

        Scanner entradaTeclado = new Scanner(System.in);

        System.out.println("Ingrese un valor entre 0 y 2");
        System.out.println("1 - Mostrar todos los clientes");
        System.out.println("2 - Eliminar cliente por numero de DNI");
        System.out.println("0 - Salir del programa");
        opcion = entradaTeclado.nextInt();

        while (opcion != 0) {

            switch (opcion) {

                case 1:
                    GestorCliente.mostrarTodosLosClientes();
                    break;
                case 2:
                   obtenerClientePorDni();
                    break;


                default:
                    System.out.println("Error al ingresar por teclado, intente nuevamente");
                    break;
            }

            System.out.println("Ingrese un valor entre 0 y 2");
            opcion = entradaTeclado.nextInt();
        }


    }

    public static void obtenerClientePorDni(){

        Scanner entradaTeclado = new Scanner(System.in);

        System.out.println("Ingrese un DNI obtener el detalle del cliente: ");
        Integer dniAObtener = entradaTeclado.nextInt();

        System.out.println(GestorCliente.obtenerDetalleCliente(dniAObtener).toString());

    }


}
