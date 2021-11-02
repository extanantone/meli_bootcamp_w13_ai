package Ejercitacion1;

public class BubbleSort {
    public static void main(String[] args) {
        int[] list = {10,20,3,1,2,5};

        int bandera;
        for(int j = list.length - 1;j > 0; j--) {
            for(int x = 0; x < j;x++){
                if(list[x] > list[x +1]) {
                    bandera = list[x];
                    list[x] = list[x + 1];
                    list[x + 1] = bandera;
                }
            }
        }
    }
}
