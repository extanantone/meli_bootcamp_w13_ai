package com.MELI;

import com.MELI.models.NoPerecedero;
import com.MELI.models.Perecedero;
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

        Producto lentejas = new NoPerecedero("Legumbres","Lentejas", 45);
        Producto leche = new Perecedero(2,"Leche", 80);
        Producto crema = new Perecedero(3,"Crema de leche", 187);
        Producto yogourth = new Perecedero(1,"Yogourth", 98);
        Producto alfajor = new NoPerecedero("Dulce", "Alfajor", 99);
        Producto harina = new NoPerecedero("Harinas","Harina de Trigo", 42);

        productos.add(lentejas);
        productos.add(leche);
        productos.add(crema);
        productos.add(alfajor);
        productos.add(harina);

        double totalCompra = 0;
        for(Producto item :productos) {
            System.out.println(item + " total: "+ item.calcular(5));
        }
    }

}
