import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        System.out.println("Noticia Temperaturas");
        int [][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        int []  tempeMinimas = {-2,-3,-8,4,6,5,0,-7,-1,-10};
        int []  tempeMaximas = {33,32,27,37,42,43,39,26,31,35};
        String[] paises = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        String paisMenor="";
        String paisMayor="";
        Arrays.sort(tempeMaximas);

        Arrays.sort(tempeMinimas);
        for(int i=0;i<tempeMinimas.length;i++){

            if(tempeMinimas[0]==temperaturas[i][0]){
                paisMenor = paises[i];

            }


        }
        for(int j=0;j<tempeMaximas.length;j++){

            if(tempeMaximas[9]==temperaturas[j][1]){
                paisMayor = paises[j];
                System.out.printf("Este es el pais"+paisMayor);
            }


        }
        System.out.println("La temperatura maxima es de:"+tempeMaximas[9]+" Grados Pertenece a "+paisMayor);
        System.out.println("La temperatura minima es de:"+tempeMinimas[0]+" Grados y Pertenece a "+paisMenor);



    }
}
