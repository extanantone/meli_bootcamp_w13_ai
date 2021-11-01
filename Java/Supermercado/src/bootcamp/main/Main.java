package bootcamp.main;

import bootcamp.models.Producto;

import java.util.List;
import java.util.Scanner;


public class Main {

    public static List<Producto> productosEnStock;

    public static void main(String[] args) {

        GestorProducto.inicializarProductos();
        GestorCliente.inicializarClientes();

        seleccionarOpcion();

    }


    public static void obtenerClientePorDni(){

        Scanner entradaTeclado = new Scanner(System.in);

        System.out.println("Ingrese un DNI obtener el detalle del cliente: ");
        Integer dniAObtener = entradaTeclado.nextInt();

        System.out.println(GestorCliente.obtenerDetalleCliente(dniAObtener).toString());

    }

    public static void seleccionarOpcion(){

        Scanner entradaTeclado = new Scanner(System.in);

        GestorFactura gestorFactura = new GestorFactura();

        System.out.println("Ingrese un valor entre 0 y 2");
        System.out.println("1 - Mostrar todos los clientes");
        System.out.println("2 - Eliminar cliente por numero de DNI");
        System.out.println("3 - Crear nueva factura");
        System.out.println("4 - Actualizar factura");
        System.out.println("0 - Salir del programa");

        int opcion = entradaTeclado.nextInt();

        while (opcion != 0) {

            switch (opcion) {

                case 1:
                    GestorCliente.mostrarTodosLosClientes();
                    break;
                case 2:
                    obtenerClientePorDni();
                    break;
                case 3:
                    gestorFactura.createElement();
                    break;
                case 4:
                    gestorFactura.updateElement();
                    break;
                case 5:
                    gestorFactura.deleteElement();
                    break;
                case 6:
                    gestorFactura.readElement();
                    break;
                case 7:
                    gestorFactura.calcularTotalFactura();



                default:
                    System.out.println("Error al ingresar por teclado, intente nuevamente");
                    break;
            }

            System.out.println("Ingrese un valor entre 0 y 2");
            System.out.println("1 - Mostrar todos los clientes");
            System.out.println("2 - Eliminar cliente por numero de DNI");
            System.out.println("3 - Crear nueva factura");
            System.out.println("4 - Actualizar factura");
            System.out.println("0 - Salir del programa");

            opcion = entradaTeclado.nextInt();
        }

    }

}
