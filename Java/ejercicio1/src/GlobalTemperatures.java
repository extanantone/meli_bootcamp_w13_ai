public class GlobalTemperatures {
    private static final String[] CITIES = {
            "Londres",
            "Madrid",
            "Nueva York",
            "Buenos Aires",
            "Asunción",
            "Sao Paulo",
            "Lima",
            "Santiago de Chile",
            "Lisboa",
            "Tokio",
    };

    private static final int[][] TEMPERATURES = {
            {-2, 33},
            {-3, 32},
            {-8, 27},
            {4, 37},
            {6, 42},
            {5, 43},
            {0, 39},
            {-7, 26},
            {-1, 31},
            {-10, 35},
    };

    private static int getMinTemperatureIndex() {
        int index = 0;
        for (int i = 1; i < TEMPERATURES.length; i++) {
            if (TEMPERATURES[i][0] < TEMPERATURES[index][0]) {
                index = i;
            }
        }
        return index;
    }

    private static int getMaxTemperatureIndex() {
        int index = 0;
        for (int i = 1; i < TEMPERATURES.length; i++) {
            if (TEMPERATURES[i][1] > TEMPERATURES[index][1]) {
                index = i;
            }
        }
        return index;
    }

    public String minTemperatureResult() {
        int index = getMinTemperatureIndex();
        String result = String.format("La menor temperatura la tuvo %s con %s ºC",
                CITIES[index], TEMPERATURES[index][0]);
        return result;
    }

    public String maxTemperatureResult() {
        int index = getMaxTemperatureIndex();
        String result = String.format("La mayor temperatura la tuvo %s con %s ºC",
                CITIES[index], TEMPERATURES[index][1]);
        return result;
    }
}
