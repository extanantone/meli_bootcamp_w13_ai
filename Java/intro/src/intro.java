public class intro {
    public static void main (String[] args){
        int [][] matriz = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        String [] ciudad ={"Londres","Madrid", "Nueva York", "Buenos aires", "asuncion", "Sao Paulo", "Lima", "Santiago de chile", "Lisboa", "Tokio"};
        String ganadora;
        int menor=matriz[0][0], mayor= matriz[1][0], c1=0, c2=0;
        for(int i=0; i<2; i++){
            for (int j=0; j<10; j++){
                if(matriz[j][i]<menor){
                    menor = matriz[j][i];
                    c1=j;
                }else if(matriz[j][i]>mayor){
                    mayor = matriz[j][i];
                    c2=j;
                }
            }
        }
        System.out.println("La menor temperatura la tuvo "+ciudad[c1]+ " con "+ menor+" grados y la mayor temperatura la tuvo "+ciudad[c2]+" con "+mayor+" grados.");
    }
}
