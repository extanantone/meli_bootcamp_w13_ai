package com.MELI;

import com.MELI.models.PracticaExcepciones;
import com.MELI.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
	// write your code here
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();
        /*try {
            int cociente = practicaExcepciones.getB() / practicaExcepciones.getA();
        } catch (ArithmeticException e){
            throw new ArithmeticException("Se ha producido un error");
            //System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }*/

        /*try {
            int cociente = practicaExcepciones.getB() / practicaExcepciones.getA();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage() + "No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }*/

        ArrayList<Producto> productos = new ArrayList<>();

        Producto arroz = new Producto("Arroz", 45);
        Producto leche = new Producto("Leche", 80);
        Producto crema = new Producto("Crema de leche", 187);
        Producto alfajor = new Producto("Alfajor", 99);
        Producto harina = new Producto("Harina de Trigo", 42);

        productos.add(arroz);
        productos.add(leche);
        productos.add(crema);
        productos.add(alfajor);
        productos.add(harina);

    }
}
