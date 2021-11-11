package com.company;

public class Main {

    public static void main(String[] args) {
        División división = new División(0, 300);

        try{
            int resultado = división.ejecutarOperacion();
            System.out.println(resultado);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }

}
