package practica2;

import practica.PracticaExcepciones;

public class Distribuidora {

    public static void main(String[] args) {
        Producto  producto = new Producto("arroz", 30);
        Producto  producto1 = new Producto("frijol", 30);
        Producto  producto2 = new Producto("atun", 100);
        Producto  producto3 = new Producto("papa", 100);
        Producto  producto4 = new Producto("lenteja", 30);


        Producto arr[] = {producto, producto1, producto2, producto3, producto4};

        System.out.println(producto.calcular(20));

        Producto  productoPerecedero1 = new Perecedero("arroz", 30, 3);
        Producto  producto1Perecedero2 = new Perecedero("frijol", 30, 1);
        Producto  producto1Perecedero3 = new Perecedero("frijol", 30, 2);
        Producto  producto1Perecedero4 = new Perecedero("frijol", 30, 3);

        System.out.println(producto1Perecedero2.calcular(20));
        System.out.println(producto1Perecedero3.calcular(20));
        System.out.println(producto1Perecedero4.calcular(20));

    }
}
