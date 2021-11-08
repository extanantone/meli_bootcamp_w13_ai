package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Ejercicio1 ej = new Ejercicio1();
        int[] arreglo = {4,0,1,-3,9,5};
        int[] arrgeloOrdenado = Ejercicio1.burbuja(arreglo);
        for (int a: arrgeloOrdenado){
            System.out.println(a);
        }
    }
}
