package com.mercadolibre;

import com.mercadolibre.dominio.PracticaExcepciones;

public class Main {

    public static void main(String[] args) {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        try{
            double cociente = practicaExcepciones.getB()/ practicaExcepciones.getA();
        } catch (IllegalArgumentException e){ //Primer ejemplo
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("No se puede dividir por cero");
        } catch (ArithmeticException ex){ //Segundo ejemplo
            throw new ArithmeticException("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }

    }
}
