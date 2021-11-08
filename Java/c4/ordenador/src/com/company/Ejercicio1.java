package com.company;

import java.util.Arrays;

public class Ejercicio1 {

    public static int[] burbuja(int[] array) {
        array = Arrays.stream(array).sorted().toArray();
/*        int aux;
        for (int i=0; i<array.length/2; i++) {
            aux = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = aux;
        }*/
        return array;
    }

}
