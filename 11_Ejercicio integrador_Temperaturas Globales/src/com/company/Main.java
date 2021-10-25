package com.company;

public class Main {

    public static void main(String[] args) {

     String ciudades[] = new String [10];

        ciudades[0]="Londres";
        ciudades[1]="Madrid";
        ciudades[2]="Nueva York";
        ciudades[3]="Buenos Aires";
        ciudades[4]="Asuncion";
        ciudades[5]="Sao Paulo";
        ciudades[6]="Lima";
        ciudades[7]="Santiago de Chile";
        ciudades[8]="Lisboa";
        ciudades[9]="Tokio";

     int temp[][]= new int[10][2];

        temp[0][0]=-2;
        temp[0][1]=33;
        temp[1][0]=-3;
        temp[1][1]=32;
        temp[2][0]=-8;
        temp[2][1]=27;
        temp[3][0]=4;
        temp[3][1]=37;
        temp[4][0]=6;
        temp[4][1]=42;
        temp[5][0]=5;
        temp[5][1]=43;
        temp[6][0]=0;
        temp[6][1]=39;
        temp[7][0]=-7;
        temp[7][1]=26;
        temp[8][0]=-1;
        temp[8][1]=31;
        temp[9][0]=-10;
        temp[9][1]=35;

        int menTemp=999; //Inicializo variables con valor irreal de temperatura para detectar en caso de algun error.
        int indiceMen=-1;
        int maxTemp=-999;
        int indiceMax=-1;

        for (int i=0; i<10; i++)
        {
            if (temp[i][0]<menTemp)
            {
                menTemp=temp[i][0];
                indiceMen=i;

            }
        }

        for (int i=0; i<10; i++)
        {
            if (temp[i][1]>maxTemp)
            {
                maxTemp=temp[i][1];
                indiceMax=i;

            }
        }

        System.out.println("La ciudad con menor temperatura es: "+ciudades[indiceMen]+" con un temperatura registrada de " +temp[indiceMen][0]+" grados centrigrados");
        System.out.println("La ciudad con mayor temperatura es: "+ciudades[indiceMax]+" con un temperatura registrada de " +temp[indiceMax][1]+" grados centrigrados");




    }
}
