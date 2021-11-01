package bootcamp.main;

import bootcamp.models.Cliente;
import bootcamp.models.Factura;
import bootcamp.models.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static bootcamp.main.GestorCliente.*;
import static bootcamp.main.GestorProducto.*;
import static bootcamp.main.Main.seleccionarOpcion;

public class GestorFactura implements CRUD{

    public static List<Factura> facturas = new ArrayList<Factura>();

    @Override
    public void createElement() {
        crearFactura();
    }

    @Override
    public void updateElement() {
        actualizarFactura();
    }

    @Override
    public void deleteElement() {
        eliminarFactura();
    }

    @Override
    public void readElement() {
        mostrarTodasLasFacturas();
    }

    public void actualizarFactura(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese codigo de factura");

        int codFactura = scanner.nextInt();

        Factura factura = obtenerFactura(codFactura);

        System.out.println("Seleccionar opcion");
        System.out.println("1 - Modificar cliente");
        System.out.println("2 - Crear nueva lista de productos");
        System.out.println("0 - Salir a menu principal");

        int option = scanner.nextInt();

        while(option != 0){

            switch(option) {

                case 1:
                    modificarCliente(factura);
                    break;
                case 2:
                    actualizarListaProductos(codFactura);
                    break;
                case 0:
                    seleccionarOpcion();
                    break;


            }

            System.out.println("Seleccionar opcion");
            System.out.println("1 - Modificar cliente");
            System.out.println("2 - Crear nueva lista de productos");
            System.out.println("0 - Crear nueva lista de productos");

            option = scanner.nextInt();
        }

    }

    public static Factura obtenerFactura(Integer codFactura){

        return facturas.stream().filter(x -> x.getCodFactura() == codFactura).findFirst().orElse(null);

    }

    public static void modificarCliente(Factura factura) {

        mostrarTodosLosClientes();

        System.out.println("Ingrese DNI de cliente que desea actualizar");

        Scanner scanner = new Scanner(System.in);

        int dni = scanner.nextInt();

        Cliente cliente = obtenerDetalleCliente(dni);

        factura.setCliente(cliente);

    }

    public void crearFactura() {

        HashMap<Integer,Integer> productos = new HashMap<Integer,Integer>();

        Scanner scanner = new Scanner(System.in);

        mostrarTodosLosClientes();

        System.out.println("Ingrese DNI de cliente que desea actualizar");

        int dni = scanner.nextInt();

        Cliente cliente = obtenerDetalleCliente(dni);

        if(cliente == null){
            System.out.println("Se detectó que el cliente ingresado no existe");

            System.out.println("Si desea crearlo ingrese 1, si desea elegir uno existente ingrese 0");

            int option = scanner.nextInt();

            switch (option){

                case 1:
                    crearCliente();
                    break;
                case 0:
                    actualizarFactura();
                    break;
            }
        }

        System.out.println("Ingrese los codigos de productos de la factura, 0 para finalizar");

        int codProd = scanner.nextInt();

        System.out.println("Ingrese la cantidad de productos");

        int cantidad = scanner.nextInt();

        while(codProd != 0){

            productos.put(codProd,cantidad);

            System.out.println("Ingrese los codigos de productos de la factura 0 para finalizar");

            codProd = scanner.nextInt();

            if(codProd != 0) {

                System.out.println("Ingrese la cantidad de productos");

                cantidad = scanner.nextInt();
            }

        }

        new Factura(cliente,productos);
    }

    public void actualizarListaProductos(Integer codFactura){

        HashMap<Integer,Integer> productos = new HashMap<Integer,Integer>();

        mostrarTodosLosProductos();

        System.out.println("Ingrese coodigo de producto que desea agregar, 0 para finalizar");

        Scanner scanner = new Scanner(System.in);

        int codProd = scanner.nextInt();

        while(codProd != 0) {

            Producto producto = obtenerDetalleProducto(codProd);

            if (producto == null) {

                System.out.println("Ingrese un producto válido");

            } else {

                System.out.println("Ingrese cantidad a comprar");

                int cantidad = scanner.nextInt();

                if (cantidad <= 0)
                    System.out.println("Ingrese un numero mayor a 0");
                else {

                    productos.put(codProd, cantidad);

                }

            }

            System.out.println("Ingrese coodigo de producto que desea agregar, 0 para finalizar");

            scanner = new Scanner(System.in);

            codProd = scanner.nextInt();

        }

        modificarListaProductos(codProd,productos);

    }

    public void modificarListaProductos(Integer codFactura, HashMap<Integer,Integer> listaProds){

        facturas.stream().filter(x -> x.getCodFactura() == codFactura).findFirst().orElse(null).setProductos(listaProds);

    }

    public void eliminarFactura(){

        Scanner scanner = new Scanner(System.in);

        mostrarTodasLasFacturas();

        System.out.println("Seleccione código de factura a eliminar");

        int codFactura = scanner.nextInt();

        Factura factura = obtenerFactura(codFactura);

        List<Factura> facturasAEliminar = new ArrayList<Factura>();
        facturasAEliminar = (List<Factura>) facturas.stream().filter(x -> x.getCodFactura() == codFactura).findFirst().orElse(null);
        productosEnStock.removeAll(facturasAEliminar);

    }

    public void mostrarTodasLasFacturas(){

        facturas.stream().forEach(System.out::println);

    }

    public void calcularTotalFactura(){

        mostrarTodasLasFacturas();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese codigo de factura a calcular total");

        int codFactura = scanner.nextInt();

        Factura factura = obtenerFactura(codFactura);

        double montoTotal = factura.calcularTotalFactura();

        System.out.println("El monto total de la factura " + codFactura + " es de: $ " + montoTotal);

    }

}


