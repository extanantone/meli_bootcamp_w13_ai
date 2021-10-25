public class ClassOne {

    private static void getMaximousTemperature(int[][] temperature, String[] cities) {
        int[] column = new int[temperature.length];
        int tmp = 0;
        int index = 0;
        for(int i = 0; i <column.length; i++){
            if (temperature[i][1] > tmp) {
                tmp = temperature[i][1];
                index = i;
            }
        }
        System.out.println("La menor temperatura es de " + cities[index] + " con " + tmp);

    }

    private static void getMinimumTemperature(int[][] temperature, String[] cities) {
        int[] column = new int[temperature.length];

        int tmp = 0;
        int index = 0;
        for(int i = 0; i <column.length; i++){
            if (temperature[i][0] < tmp) {
                tmp = temperature[i][0];
                index = i;
            }
        }
        System.out.println("La menor temperatura es de " + cities[index] + " con " + tmp);
    }
    public static void main(String[] args) {
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos aires", "Asunción", "Sao Paolo", "Lima", "Santiago de chile", "Lisboa", "Tokio"};
        int[][] temperature = {
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35},
        };
        getMinimumTemperature(temperature, cities);
        getMaximousTemperature(temperature, cities);
    }
}
