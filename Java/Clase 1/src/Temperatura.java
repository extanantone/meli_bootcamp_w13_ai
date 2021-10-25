import java.util.Scanner;

public class Temperatura {

    public static void main(String[] args) {

        String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int matriz[][] = new int [10][2];
        int mayor = matriz[0][0];
        int menor = matriz[0][0];

        matriz[0][0] = -2;
        matriz[0][1] = 33;
        matriz[1][0] = -3;
        matriz[1][1] = 32;
        matriz[2][0] = -8;
        matriz[2][1] = 27;
        matriz[3][0] = 4;
        matriz[3][1] = 37;
        matriz[4][0] = 6;
        matriz[4][1] = 42;
        matriz[5][0] = 5;
        matriz[5][1] = 43;
        matriz[6][0] = 0;
        matriz[6][1] = 39;
        matriz[7][0] = -7;
        matriz[7][1] = 26;
        matriz[8][0] = -1;
        matriz[8][1] = 31;
        matriz[9][0] = -10;
        matriz[9][1] = 35;

        for (int f=0; f<matriz.length; f++) {
            for (int c=0; c<matriz[0].length; c++) {
                int numeroActual = matriz[f][c];
                if (numeroActual > mayor)
                    mayor = numeroActual;
                if (numeroActual < menor)
                    menor = numeroActual;
            }
        }
        System.out.printf("La mayor temperatura %d y la menor es %d",mayor,menor);

    }
}
