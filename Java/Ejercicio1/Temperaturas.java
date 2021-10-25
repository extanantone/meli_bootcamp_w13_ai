import java.util.Arrays;


public class Temperaturas {

    public static void main(String[] args) {

        String ciudades [] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int temperaturas [][] = { {-2,33}, {-3,32}, {-8,27}, {4,37}, {6,42}, {5,43}, {0,39},
                {-7,26}, {-1,31}, {-10,35} };

        int mayor = -100;

        int menor = 200;

        int posMenor=0, posMayor=0;

        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                
                if(temperaturas[i][0]<menor){
                    menor = temperaturas[i][0];
                    posMenor = i;
                }

                if (temperaturas[i][1]>mayor){
                    mayor = temperaturas[i][1];
                    posMayor=i;
                }
            }
        }

        System.out.printf("La mayor temperatura registrada fue de %dºC y fue registrada en %s",
                mayor,ciudades[posMayor]);

        System.out.printf("\nLa menor temperatura registrada fue de %dºC y fue registrada en %s",
                menor,ciudades[posMenor]);
    }


}
