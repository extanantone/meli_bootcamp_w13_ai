package Productos;

import java.io.IOError;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Distribuidora {
    public static void main (String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de productos: ");
        int cantProductos;

        try {
            cantProductos = entrada.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("La cantidad de productos debe ser un número natural");
        }

        System.out.println("Ingrese ahora por cada producto sus respectivos datos.");
        ArrayList<Producto> lineaDeProductos = new ArrayList<>();
        for(int contador = 0; contador < cantProductos; contador++) {
            System.out.println("Producto Nº" + (contador+1));
            System.out.println("¿Qué tipo de producto es?\n1) Perecedero\n2) No perecedero\n3) No sé");
            int tipoDeProducto;
            try {
                tipoDeProducto = entrada.nextInt();
                tipoDeProducto = (tipoDeProducto-1)%3+1;
            } catch (InputMismatchException e) {
                tipoDeProducto = 3;
                entrada.nextLine();
            }
            System.out.print("Ingrese el nombre: ");
            String inNombre = entrada.next();
            System.out.print("Ahora el precio: ");
            double inPrecio;
            try {
                inPrecio = entrada.nextDouble();
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("El precio debe ser un número de punto flotante");
            }
            switch(tipoDeProducto) {
                case 1:
                    System.out.print("Finalmente, los días por caducar: ");
                    int inDiasPorCaducar;
                    try {
                        inDiasPorCaducar = entrada.nextInt();
                        inDiasPorCaducar = (inDiasPorCaducar-1)%3+1;
                    } catch (InputMismatchException e) {
                        throw new IllegalArgumentException("La cantidad de días por caducar debe ser un número natural");
                    }
                    Perecedero nuevoPer = new Perecedero(inNombre, inPrecio, inDiasPorCaducar);
                    lineaDeProductos.add(nuevoPer);
                    break;
                case 2:
                    System.out.print("Finalmente, el tipo de producto: ");
                    String inTipo = entrada.next();
                    NoPerecedero nuevoNoPer = new NoPerecedero(inNombre, inPrecio, inTipo);
                    lineaDeProductos.add(nuevoNoPer);
                    break;
                case 3:
                    Producto nuevoProd = new Producto(inNombre, inPrecio);
                    lineaDeProductos.add(nuevoProd);
                    break;
            }
        }
        System.out.println("Bien, estos son los precios finales para 5 productos de cada uno:");
        for (Producto p : lineaDeProductos) {
            System.out.println(p.calcular(5));
        }
    }
}
