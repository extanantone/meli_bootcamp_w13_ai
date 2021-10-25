public class app {

    /** Se generan valores constantes**/

    final static int FILA = 10;
    final static int COLUMNA = 2;
    final static int INICIALIZACION = 0;

    public static void main(String[] args) {

        int temperaturaMin = INICIALIZACION;
        int temperaturaMax = INICIALIZACION;
        int paisMin = INICIALIZACION;
        int paisMax = INICIALIZACION;

        String paises [] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio"};

        int temperaturas [][] = { {-2,33}, {-3,32},
                                  {-8,27}, {4,37},
                                  {6,42}, {5,43},
                                  {0,39}, {-7,26},
                                  {-1,31}, {-10,35} };

        for (int i=0; i < FILA; i++){
            for (int j=0; j < COLUMNA; j++){

                if(temperaturas[i][j] > temperaturaMax){

                    temperaturaMax = temperaturas[i][j];
                    paisMax = i;

                }


                if( temperaturas[i][j] < temperaturaMin){

                    temperaturaMin = temperaturas[i][j];
                    paisMin = i;
                }

            }
        }

        System.out.println("La temperatura Máxima es " + temperaturaMax + " correspondiente al país " +
                 paises[paisMax]);

        System.out.println("La temperatura Mínima es " + temperaturaMin + " correspondiente al país " +
                paises[paisMin]);


    }
}
