package com.company;
import java.beans.XMLEncoder;
import java.util.LinkedList;
import java.util.List;

public class Main {
    List<String> mensajeStrings = new LinkedList<>();
    //Mensaje final
    static String mensajeFinal = "Este es el último mensaje";

    static int[] numeros = new int[5];

    static public void asignarValor() {
        //Código que arroja excepción, escribi tu codigo aqui
        try {
            numeros[5] = 10;
        } catch (IndexOutOfBoundsException e) {
            imprimirMensaje(e.getMessage());
        } finally {
            imprimirMensaje(mensajeFinal);
        }
    }

    private static void imprimirMensaje(String mensaje) {
        //mensajeStrings.add(mensaje);
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
	// write your code here
        Main.asignarValor();
    }
}