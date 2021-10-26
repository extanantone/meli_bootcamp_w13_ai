package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Distribuidora {

    static List<Producto> productos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Producto arroz = new Perecedero("Arroz", 40.99, 6);
        productos.add(arroz);
        Producto arrozProntoAVencer = new Perecedero("Arroz", 40.99, 2);
        productos.add(arrozProntoAVencer);
        Producto remera = new NoPerecedero("Remera", 890.23, "Ropa");
        productos.add(remera);

        System.out.println(arroz.toString());
        mensajeVender(arroz, 5);
        System.out.println(arrozProntoAVencer.toString());
        mensajeVender(arrozProntoAVencer, 5);
        System.out.println(remera.toString());
        mensajeVender(remera, 5);

        while(true){
            System.out.println("\n Ingrese una opción");
            System.out.println("1 - Agregar producto");
            System.out.println("2 - Calcular venta de producto");
            System.out.println("3 - Ver productos");
            System.out.println("Ó5 presione cualquier otro numero para salir");

            int resp = sc.nextInt();
            switch (resp){
                case(1):{
                    agregarProducto();
                    break;
                }
                case(2):{
                    ventaProducto();
                    break;
                }
                case(3):{
                    for (Producto p : productos){
                        System.out.println(p.toString());
                    }
                    break;
                }
                default:
                    return;
            }
        }

    }

    private static void ventaProducto() {
        System.out.println("Ingrese el indice y la cantidad del producto a vender");
        int idx = sc.nextInt();
        int cantidad = sc.nextInt();
        Producto prod = productos.get(idx);
        mensajeVender(prod, cantidad);

    }

    public static void mensajeVender(Producto producto, int cantidad){
        System.out.format("El precio de vender %d unidades de %s es $%f \n\n", cantidad, producto.getNombre(), producto.calcular(cantidad));

    }

    public static void agregarProducto(){
        System.out.println("Que tipo de producto desea ingresar? (1 - Perecerdero/2 - No Perecedero)");
        int resp = sc.nextInt();

        System.out.println("Ingrese nombre y precio");
        String nombre = sc.next();
        float precio = sc.nextFloat();

        if (resp == 1){
            System.out.println("Ingrese los dias por caducar");
            int diasCaducar = sc.nextInt();
            productos.add(new Perecedero(nombre, precio, diasCaducar));
        }
        else{
            System.out.println("Ingrese el tipo");
            String tipo = sc.next();
            productos.add(new NoPerecedero(nombre, precio, tipo));
        }
    }
}
