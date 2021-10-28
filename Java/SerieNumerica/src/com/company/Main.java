package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Integer valor = 0;
        Prototipo prototipo=new ValorInicial(valor);
        prototipo.valInicial();
        Integer a= prototipo.numSiguiente();
        System.out.println("El ultimo numero mostrado es: "+a);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Desea reiniciar la serie: S o N/ o x para salir");
        String serie = teclado.nextLine();

        while (serie != "x"){

            switch (serie) {

                case "s":
                    prototipo.rinSerie();
                    prototipo.numSiguiente();
                    break;
                case "n":
                    System.out.println("Desea ingresar un nuevo valor: S o N ");
                    String nuevo=teclado.nextLine();
                    switch (nuevo){
                        case "s":
                            prototipo.valInicial();
                            prototipo.numSiguiente();
                        case "n":
                            return;
                        default:
                            System.out.println("la variable ingresada no es valida intente nuevamente");
                            break;
                    }
                    break;
                default:
                    System.out.println("Error al ingresar por teclado, intente nuevamente");
                    break;
            }
            System.out.println("Desea reiniciar la serie: S o N/ o x para salir");
            serie = teclado.nextLine();
        }
        return;

    }
}
