public class Practica1 {
    public static void main(String[] args){
        String[] ciudades = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int temperaturas[][] = {{-2,-3,-8,4,6,5,0,-7,-1,-10},{33,32,27,37,42,43,29,26,31,35}};
        int minValue = Integer.MAX_VALUE;
        int minPosition = 0;
        int maxValue = Integer.MIN_VALUE;
        int maxPosition = 0;
        for(int i = 0; i < ciudades.length; i++){
            if(temperaturas[0][i] < minValue){
                minValue = temperaturas[0][i];
                minPosition = i;
            }
            if(temperaturas[1][i] > maxValue){
                maxValue = temperaturas[1][i];
                maxPosition = i;
            }
        }
        System.out.println("La menor temperatura la tuvo " + ciudades[minPosition] + ", con " + String.valueOf(minValue) + " º C.");
        System.out.println("La mayor temperatura la tuvo " + ciudades[maxPosition] + ", con " + String.valueOf(maxValue) + " º C.");
    }
}
