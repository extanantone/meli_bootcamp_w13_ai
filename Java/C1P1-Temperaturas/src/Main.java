public class Main {

    public static void main(String[] args){
        String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","Sao Paulo", "Lima", "Santiago de Chile", "Lisboa","Tokio"};
        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        int temMin = temperaturas[0][0], indMin = 0;
        int temMax = temperaturas[0][1], indMax = 0;


        System.out.println("********** Reporte de temperaturas **********");

        for( int i = 1; i < temperaturas.length; i++ ){
            if( temperaturas[i][0] < temMin ){
                indMin = i;
                temMin = temperaturas[i][0];
            }
        }

        for( int i = 1; i < temperaturas.length; i++ ){
            if( temperaturas[i][1] > temMax ){
                indMax = i;
                temMax = temperaturas[i][1];
            }
        }

        System.out.println("La temperatura Mínima es " +
                temMin + " en la ciudad de " +
                ciudades[indMin]);

        System.out.println("La temperatura Máxima es " +
                temMax + " en la ciudad de " +
                ciudades[indMax]);

    }
}
