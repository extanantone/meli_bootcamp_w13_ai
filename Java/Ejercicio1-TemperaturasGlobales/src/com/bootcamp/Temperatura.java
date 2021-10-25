package com.bootcamp;

public class Temperatura {

    public static int lowestTemperature = 0;
    public static int highestTemperature = 0;
    public static String lowestTemperatureCity;
    public static String highestTemperatureCity;

    public static String []cities = new String[10];
    public static int [][] temperatures = new int[10][2];


    public static void main(String[] args) {
        initialiceCities();
        initialiceTemperatures();
        searchLowestAndHighestTemperatures();
    }


    private static void initialiceCities(){
        cities[0] = "Londres";
        cities[1] = "Madrid";
        cities[2] = "Nueva York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asuncion";
        cities[5] = "Sao Paulo";
        cities[6] = "Lima";
        cities[7] = "Santiago de Chile";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";
    }

    private static void initialiceTemperatures(){
        temperatures[0][0] = -2;
        temperatures[0][1] = 33;

        temperatures[1][0] = -3;
        temperatures[1][1] = 32;

        temperatures[2][0] = -8;
        temperatures[2][1] = 27;

        temperatures[3][0] = 4;
        temperatures[3][1] = 37;

        temperatures[4][0] = 6;
        temperatures[4][1] = 42;

        temperatures[5][0] = 5;
        temperatures[5][1] = 43;

        temperatures[6][0] = 0;
        temperatures[6][1] = 39;

        temperatures[7][0] = -7;
        temperatures[7][1] = 26;

        temperatures[8][0] = -1;
        temperatures[8][1] = 31;

        temperatures[9][0] = -10;
        temperatures[9][1] = 35;

    }

    private static void searchLowestAndHighestTemperatures(){

        if(!verifySameLength()){
            System.out.println("La longitud del vector de ciudades no coincide con la longitud de la matriz de temperaturas");
            return;
        }


        for(int i=0;i<cities.length;i++){

            if(temperatures[i][0]< lowestTemperature){
                lowestTemperature = temperatures[i][0];
                lowestTemperatureCity = cities[i];

            }

            if(temperatures[i][1] > highestTemperature){
                highestTemperature = temperatures[i][1];
                highestTemperatureCity = cities[i];
            }

        }

        System.out.println("La ciudad con la temperatura mas baja es: " + lowestTemperatureCity + " con: " + lowestTemperature +" grados\n");
        System.out.println("La ciudad con la temperatura mas alta es: " + highestTemperatureCity + " con: " + highestTemperature +" grados\n");

    }

    private static boolean verifySameLength(){
        return cities.length == temperatures.length;
    }

}
