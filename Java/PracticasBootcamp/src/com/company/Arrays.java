package com.company;

public class Arrays {
    public static void main(String[] args) {
        String ciudades [] = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo","Lima"
                ,"Santiago de Chile","Lisboa","Tokio"};
        int temperatura [][] =  new int[10][2];
        temperatura[0][0]=-2;
        temperatura[0][1] =33;
        temperatura[1][0]=-3;
        temperatura[1][1]=32;
        temperatura[2][0]=-8;
        temperatura[2][1]=27;
        temperatura[3][0]=4;
        temperatura[3][1]=37;
        temperatura[4][0]=6;
        temperatura[4][1]=42;
        temperatura[5][0]=5;
        temperatura[5][1]=43;
        temperatura[6][0]=0;
        temperatura[6][1]=39;
        temperatura[7][0]=-7;
        temperatura[7][1]=26;
        temperatura[8][0]=-1;
        temperatura[8][1]=31;
        temperatura[9][0]=-10;
        temperatura[9][1]=35;

        int mayorTemperatura=0;
        int menorTempertura=0;
        String ciudadMaTemp="";
        String ciudadMeTemp="";

        for(int i=0 ; i < ciudades.length ; i++ ){

            if (i==0){
                ciudadMaTemp = ciudades[i];
                ciudadMeTemp = ciudadMaTemp;
                menorTempertura = temperatura[0][0];
                mayorTemperatura = temperatura[0][1];
            }else{

                for (int j =0; j < temperatura[i].length ;j++ ) {
                    if (j == 0) {
                        if(menorTempertura > temperatura[i][j]){
                            menorTempertura =   temperatura[i][j];
                            ciudadMeTemp = ciudades[i];
                        }
                    }else{
                        if(mayorTemperatura < temperatura[i][j]){
                            mayorTemperatura =   temperatura[i][j];
                            ciudadMaTemp = ciudades[i];
                        }
                    }
                }
            }


        }

        System.out.println("La ciudad con menor tempertura es:"+ciudadMeTemp +" con  "+menorTempertura);
        System.out.println("La ciudad con mayor tempertura es:"+ciudadMaTemp +" con  "+mayorTemperatura);
    }
}
