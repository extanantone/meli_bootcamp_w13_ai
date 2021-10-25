package Ejercicio_matrices;
public class Main{  
    public static void main (String[] args) {
        String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires", "Asuncion","Sao Pablo","Lima","Santiago de Chile","Lisboa", "Tokio"};
        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        int min_temp=0;
        int max_temp=0;
        String min_temp_city="";
        String max_temp_city="";

        for (int i=0; i < ciudades.length; i++) {
            if(i==0){
                min_temp=temperaturas[i][0];
                max_temp=temperaturas[i][1];
                min_temp_city=ciudades[i];
                max_temp_city=ciudades[i];
            }else{
                if(min_temp > temperaturas[i][0]){
                    min_temp= temperaturas[i][0];
                    min_temp_city=ciudades[i];
                }
                if(max_temp < temperaturas[i][1]){
                    max_temp= temperaturas[i][1];
                    max_temp_city=ciudades[i];
                }

            }
        }
        System.out.println("La menor temperatura la tuvo "+min_temp_city+" con "+min_temp+" ºC");
        System.out.println("La mayor temperatura la tuvo "+max_temp_city+" con "+max_temp+" ºC");
    }
}