public class GlobTemp {

    private static void getMinAndMaxValues(int[][] citiesTemps, int[] min, int[] max)
    {
        int i;
        int size = citiesTemps.length;

        for (i = 1; i < size; i++)
        {
            if (citiesTemps[i][0] < min[1])
            {
                min[1] = citiesTemps[i][0];
                min[0] = i;
            }
            if (citiesTemps[i][1] > max[1])
            {
                max[1] = citiesTemps[i][1];
                max[0] = i;
            }
        }
    }

    public static void main(String[] args) {
        String[] cities = {
                "Londres", "Madrid",
                "Nueva York", "Buenos aires",
                "Asunción", "Sao Paulo",
                "Lima", "Santiago de Chile",
                "Lisboa", "Tokio"
        };
        int[][] citiesTemps = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 36},
                {-10, 35},
        };
        int[] minCity = { 0, citiesTemps[0][0] };
        int[] maxCity = { 0, citiesTemps[0][1] };

        getMinAndMaxValues(citiesTemps, minCity, maxCity);
        System.out.println(String.format("la menor temperatura la tuvo %s, con %d º C", cities[minCity[0]], minCity[1]));
        System.out.println(String.format("la mayor temperatura la tuvo %s, con %d º C", cities[maxCity[0]], maxCity[1]));
    }
}