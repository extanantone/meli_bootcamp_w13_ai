package com.MELI;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago De Chile", "Lisboa","Tokio"};
        int  [][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int tempMenor = temperaturas[0][0];
        int tempMayor = temperaturas[0][0];
        String ciudadMenTemp = " ";
        String ciudadMayTemp = " ";

        for (int i = 0; i < temperaturas.length; i++) {
            for (int j=0; j < temperaturas[i].length; j++) {

                if(tempMenor > temperaturas[i][0]) {
                    tempMenor = temperaturas[i][0];
                    ciudadMenTemp = ciudades[i];
                }
                if(tempMayor < temperaturas[i][1]) {
                    tempMayor = temperaturas[i][1];
                    ciudadMayTemp = ciudades[i];
                }
            }
        }
        
        System.out.println(Arrays.toString(ciudades));
        System.out.println("La menor temperatura la tuvo " + ciudadMenTemp + ", con " + tempMenor + "ºC.");
        System.out.println("La mayor temperatura la tuvo " + ciudadMayTemp + ", con " + tempMayor + "ºC.");
    }
}
