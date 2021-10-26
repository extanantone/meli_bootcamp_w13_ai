public class Main {
    public static void main(String[] args) {

        int temMin = 0;
        int posTempMin = 0;

        int temMax = 0;
        int posTempMax = 0;

        String[] ciudad = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santigo de Chile", "lisboa", "Tokyo"};

        int[][] temperatura = {{-2, -3, -8, 4, 6, 5, 0, -7, -1, -10}, {33, 32, 27, 37, 42, 43, 39, 26, 31, 35}};

        for (int i = 0; i < temperatura[0].length; i++) {

            if (temperatura[0][i] <= temMin) {
                temMin = temperatura[0][i];
                posTempMin = i;
            }

            if (temperatura[1][i] >= temMax) {
                temMax = temperatura[1][i];
                posTempMax = i;
            }
        }


        System.out.println("La temperatura mas baja pertenece a: " + ciudad[posTempMin] + " con una temperatura de: " +  temMin);
        System.out.println("La temperatura mas alta pertenece a: " + ciudad[posTempMax] + " con una temperatura de: " +  temMax);


    }
}
