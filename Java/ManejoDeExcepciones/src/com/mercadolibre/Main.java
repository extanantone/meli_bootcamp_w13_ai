package com.mercadolibre;

import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<String> mensajeStrings = new LinkedList<>();
    static String mensajeFinal = "Este es el último mensaje";
    static int[] numeros = new int[5];
    public static void main(String[] args) {
        asignarValor();

    }

    public static void asignarValor() {
        try {
            numeros[5] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        } finally {
            imprimirMensaje(mensajeFinal);
        }
    }

    public static void imprimirMensaje(String mensaje) {
        mensajeStrings.add(mensaje);
        System.out.println(mensaje);
    }
}

