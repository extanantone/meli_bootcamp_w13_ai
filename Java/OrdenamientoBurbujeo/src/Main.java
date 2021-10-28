public class Main {

    public static void main(String[] args) {

        int [] array = new int[] {5,3,1,4,2};

        array = burbuja(array);

        for (int i=0; i<5; i++)
            System.out.println(array[i]);
    }

    public static int[] burbuja(int[] array) {

        for(int i=0;i<array.length;i++){

            for(int j=i+1;j<array.length;j++){

                if(array[i]>array[j]){

                    int aux = array[i];

                    array[i] = array[j];

                    array[j] = aux;

                }
            }
        }

        return array;
    }
}
