public class globalTemperatures {
    static String[] cities = {
            "Londres",
            "Madrid",
            "Nueva York",
            "Buenos Aires",
            "Asuncion",
            "Sao Paulo",
            "Lima",
            "Santiago de Chile",
            "Lisboa",
            "Tokio"
    };

    static int[][] temperatures = {
            { -2, 33 },
            { -3, 32 },
            { -8, 27 },
            { 4, 37 },
            { 6, 42 },
            { 5, 43 },
            { 0, 39 },
            { -7, 26 },
            { -1, 31 },
            { -10, 35 },
    };

    public static void main(String[] args) {
        int ind_min = 0;
        int min_temp = temperatures[0][0];
        int ind_max = 0;
        int max_temp = temperatures[0][1];

        for (int i = 0; i<10; i++) {
            if (temperatures[i][0] < min_temp) {
                ind_min = i;
                min_temp = temperatures[i][0];
            }
            if (temperatures[i][1] > max_temp) {
                ind_max = i;
                max_temp = temperatures[i][1];
            }
        }

        System.out.println("La menor temperatura la tuvo " + cities[ind_min] + ", con " + min_temp + "°C");
        System.out.println("La mayor temperatura la tuvo " + cities[ind_max] + ", con " + max_temp + "°C");
    }
}
