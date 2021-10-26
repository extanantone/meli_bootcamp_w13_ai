public class TemperaturaGlobal {

    public static void main(String[] args) {
        String[] ciudades = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Pablo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperaturas = new int[][]{{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int minTemperatura = temperaturas[0][0];
        int maxTemperatura = temperaturas[0][1];

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < ciudades.length; i++) {
            if (temperaturas[i][0] < minTemperatura) {
                minTemperatura = temperaturas[i][0];
                minIndex = i;
            }

            if (temperaturas[i][1] > maxTemperatura) {
                maxTemperatura = temperaturas[i][1];
                maxIndex = i;
            }
        }
        
        System.out.println("La mayor temperatura fue " + maxTemperatura + "ºC en la ciudad de: " + ciudades[maxIndex]);
        System.out.println("La menor temperatura fue " + minTemperatura + "ºC en la ciudad de: " + ciudades[minIndex]);
    }

}
