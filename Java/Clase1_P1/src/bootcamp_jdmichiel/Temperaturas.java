package bootcamp_jdmichiel;

public class Temperaturas {

    String[] ciudades = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
            "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

    int[][] temperatura = new int[][]{{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42},
            {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

    public void calcTemperatura() {
        int temp_maxima = Integer.MIN_VALUE;
        int indiceMaximo = 0;
        int temp_minima = Integer.MAX_VALUE;
        int indiceMinimo = 0;

        for (int i = 0; i < ciudades.length; i++) {

            if (temp_maxima < temperatura[i][1]) {
                temp_maxima = temperatura[i][1];
                indiceMaximo = i;
            }

            if (temp_minima > temperatura[i][0]) {
                temp_minima = temperatura[i][0];
                indiceMinimo = i;
            }
        }
        System.out.println("La ciudad con la temperatura mas baja es " + ciudades[indiceMinimo] + " con " + temp_minima + " grados.");
        System.out.println("La ciudad con la temperatura mas alta es " + ciudades[indiceMaximo] + " con " + temp_maxima + " grados.");

    }

    public static void main(String[] args) {
        new Temperaturas().calcTemperatura();
    }

}
