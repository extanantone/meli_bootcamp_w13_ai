package introjava.p1;

public class Main {

    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] valores = {{-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}};

        int contadorCiudadesMin = 0;
        int contadorCiudadesMax = 0;
        int menor = valores[0][0];
        int mayor = valores[0][1];

        for (int i = 0; i < valores.length; i++) {
            //identifico si es la ciiudad con la menor temperatura
            if (valores[i][0] < menor) {
                menor = valores[i][0];
                contadorCiudadesMin = i;
            }
            // identifico si es la ciudad con la mayor temperatura
            if (valores[i][1] > mayor) {
                mayor = valores[i][1];
                contadorCiudadesMax = i;
            }
        }
        // salida en consola
        System.out.println("La ciudad con la temperatura menor es : " +
                ciudades[contadorCiudadesMin] + " = " +
                String.valueOf(valores[contadorCiudadesMin][0]) +
                ", la ciudad con la máxima temperatura es: " +
                ciudades[contadorCiudadesMax] + " = " +
                String.valueOf(valores[contadorCiudadesMax][1]));
    }
}
