package AM;

import java.util.Arrays;

public class AlgoritmosDeOrdenamiento {
    public static int[] burbuja(int[] array) {
        Arrays.sort(array);

        return array;
    }

    public static void main(String[] args) {
        int[] numeros = {33, 9, 80, 27, 51, 99, 46, 98, 55, 83};

        for (int numero : burbuja(numeros)) {
            System.out.println(numero);
        }
    }
}