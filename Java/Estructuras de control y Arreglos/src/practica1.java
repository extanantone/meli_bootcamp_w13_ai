public class practica1 {
    public static void main(String[] args) {
        String[] ciudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio",
        };

        int[][] temperaturas = {
            {-2, 33},
            {-3, 32},
            {-8, 27},
            {4, 47},
            {6, 42},
            {5, 43},
            {0, 39},
            {-7, 26},
            {-1, 31},
            {-10, 35},
        };

        int tempMin = 0;
        int tempMax = 0;
        int indiceCiudadMin = 0;
        int indiceCiudadMax = 0;

        for (int i = 0; i<temperaturas.length; i++) {
            if (tempMin >= temperaturas[i][0]){
                tempMin = temperaturas[i][0];
                indiceCiudadMin = i;
            }

            if (tempMax <= temperaturas[i][1]){
                tempMax = temperaturas[i][1];
                indiceCiudadMax = i;
            }
        }

        System.out.println("Temperatura minima: " + ciudades[indiceCiudadMin] + " " + tempMin);
        System.out.println("Temperatura maxima: " + ciudades[indiceCiudadMax] + " " + tempMax);
    }
}
