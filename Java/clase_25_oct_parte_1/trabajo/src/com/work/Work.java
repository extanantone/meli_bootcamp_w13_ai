package com.work;

class Work{
    // Nombre de las ciudades
    public static String[] citys = {
                                        "Londres",
                                        "Madrid",
                                        "Nueva York",
                                        "Buenos Aires",
                                        "Asunción",
                                        "São Paulo",
                                        "Lima",
                                        "Santiago de Chile",
                                        "Lisboa",
                                        "Tokio"
                                    };
    // Temperatura (min,max)
    public static int[][] temperature = {
                                        {-2,33},
                                        {-3,32},
                                        {-8,27},
                                        {4,37},
                                        {6,42},
                                        {5,43},
                                        {0,39},
                                        {-7,26},
                                        {-1,31},
                                        {-10,35}
                                        };

    public static void main(String[] args){
        int indexMinCityTemperature = 0;
        int indexMaxCityTemperature = 0;
        for(int i=0;i<citys.length;i++){

            if(temperature[i][0]<temperature[indexMinCityTemperature][0]){
                indexMinCityTemperature = i;
            }

            if(temperature[i][1]>temperature[indexMaxCityTemperature][1]){
                indexMaxCityTemperature = i;
            }
        }
        System.out.println("Ciudad max temperatura: "+citys[indexMaxCityTemperature]);
        System.out.println("Temperatura: "+temperature[indexMaxCityTemperature][1]);
        System.out.println();
        System.out.println("Ciudad min temperatura: "+citys[indexMinCityTemperature]);
        System.out.println("Temperatura: "+temperature[indexMinCityTemperature][0]);
        System.out.println();
        
    }

}