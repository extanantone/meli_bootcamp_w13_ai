public class Java_I {
        public static void main(String[] args) {
            int maxIndex = 0;
            int minIndex = 0;
            String[] ciudades = {
                    "Londres",
                    "Madrid",
                    "Nueva York",
                    "Buenos Aires",
                    "Asunción",
                    "São Paulo",
                    "Lima",
                    "Santiago de Chile",
                    "Lisboa",
                    "Tokio"};
            int[][] temperaturas = {{-2,-3,-8,4,6,5,0,-7,-1,-10},{33,32,27,37,42,43,39,26,31,35}};
            for(int i = 0;i < ciudades.length;i++){
                if (temperaturas[0][minIndex] > temperaturas[0][i] ) {minIndex = i;}
                if (temperaturas[1][maxIndex] < temperaturas[1][i] ) {maxIndex = i;}
            }
            System.out.println("La temperatura minima es: " + temperaturas[0][minIndex] + " C° en la ciudad: " + ciudades[minIndex]);
            System.out.println("La temperatura maxima es: " + temperaturas[1][maxIndex] + " C° en la ciudad: " + ciudades[maxIndex]);
        }
}
