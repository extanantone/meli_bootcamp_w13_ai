public class Temperaturas {
    public static void main (String[] args) {
        String ciudades[] = {
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
        int temperaturas[][] = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-1, 35}
        };

        int indiceCiudadMayorTemp = 0;
        int indiceCiudadMenorTemp = 0;
        for(int indiceFila = 1; indiceFila < temperaturas.length; indiceFila++) {
            if (temperaturas[indiceFila][1] > temperaturas[indiceCiudadMayorTemp][1]) {
                indiceCiudadMayorTemp = indiceFila;
            }
            if (temperaturas[indiceFila][0] < temperaturas[indiceCiudadMenorTemp][0]) {
                indiceCiudadMenorTemp = indiceFila;
            }
        }

        System.out.println("Reporte meteorológico:");
        System.out.println(String.format("La mayor temperatura registrada fue de %d grados Celcius, proveniente de %s.",temperaturas[indiceCiudadMayorTemp][1], ciudades[indiceCiudadMayorTemp]));
        System.out.println(String.format("Mientras tanto, la menor registrada fue de %d grados Celcius, proveniente de %s.", temperaturas[indiceCiudadMenorTemp][0], ciudades[indiceCiudadMenorTemp]));
    }
}