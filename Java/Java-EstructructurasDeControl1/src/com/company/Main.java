package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String[] ciudades = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","Säo Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35} };
        int temperaturaMenor = 0;
        int idTempMenor = 0;
        int temperaturaMayor = 0;
        int idTempMayor = 0;
        //Consultar la ciudad con mayor y menor temperatura

        for (int i = 0; i < temperaturas.length; i++){
            if (temperaturas[i][0] < temperaturaMenor){
                temperaturaMenor = temperaturas[i][0];
                idTempMenor = i;
            }
            if (temperaturas[i][1] > temperaturaMayor){
                temperaturaMayor = temperaturas[i][1];
                idTempMayor = i;
            }
        }

        System.out.println("Ciudad con temperatura menor "+ciudades[idTempMenor] + ", "+temperaturaMenor);
        System.out.println("Ciudad con temperatura mayor "+ciudades[idTempMayor] + ", "+temperaturaMayor);
    }
}
