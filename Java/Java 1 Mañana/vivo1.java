public class vivo1 {

    public static void main(String[] args) {
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
        int indiceTempMenorCiudad = 0;
        int indiceTempMayorCiudad = 0;

        for (int i = 1; i < temperaturas.length; i++){
            if (temperaturas[i][0] < temperaturas[indiceTempMenorCiudad][0]){
                indiceTempMenorCiudad = i;
            }
            if (temperaturas[i][1] > temperaturas[indiceTempMayorCiudad][1]){
                indiceTempMayorCiudad = i;
            }
        }

        System.out.println(String.format("La mayor temperatura fue de "+temperaturas[indiceTempMayorCiudad][1]+" en " + ciudades[indiceTempMayorCiudad]));
        System.out.println(String.format("La menor temperatura fue de "+temperaturas[indiceTempMenorCiudad][0]+" en " + ciudades[indiceTempMenorCiudad]));

    }
}
