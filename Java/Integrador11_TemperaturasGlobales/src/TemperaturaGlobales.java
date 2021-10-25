public class TemperaturaGlobales {

    String[] ciudad= {"Londres", "Madrid", "Nueva York", "Buenos Aires","Asunción",
            "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
    int[][] temperatura = {{-2,33}, {-3,32}, {-8, 27}, {4, 37}, {6,42},
            {5,43}, {0,39}, {-7,26}, {-1, 31}, {-10,35}};

    public void calcularTemperatura(){
        int maxTemp = Integer.MIN_VALUE;
        int indiceMax = 0;
        int minTemp = Integer.MAX_VALUE;
        int indiceMin = 0;
        for(int i=0; i<ciudad.length; i++){
            if(minTemp>temperatura[i][0]){
                minTemp=temperatura[i][0];
                indiceMin = i;
            }
            if(maxTemp<temperatura[i][1]){
                maxTemp=temperatura[i][1];
                indiceMax = i;
            }
        }
        System.out.println("La temperatura Mínima es: "+minTemp+" de la ciudad de "+ciudad[indiceMin]);
        System.out.println("La temperatura Máxima es: "+maxTemp+" de la ciudad de "+ciudad[indiceMax]);
    }

    public static void main(String[] args) {
        new TemperaturaGlobales().calcularTemperatura();
    }
}
