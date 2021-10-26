public class Ejercicio1 {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int temperaturas[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, -35}};

        int tempMayor[] = {temperaturas[0][0], 0};
        int tempMenor[] = {temperaturas[0][1], 0};

        for (int i = 0; i < ciudades.length; i++) {
            if (tempMenor[0] > temperaturas[i][0]) {
                tempMenor[0] = temperaturas[i][0];
                tempMenor[1] = i;
            }

            if (tempMayor[0] < temperaturas[i][1]) {
                tempMayor[0] = temperaturas[i][1];
                tempMayor[1] = i;
            }
        }

        System.out.println("La ciudad con temperatura mayor es " + ciudades[tempMayor[1]] + " con "+  tempMayor[0] + " grados centigrados");
        System.out.println("La ciudad con temperatura menor es " + ciudades[tempMenor[1]] + " con "+  tempMenor[0] + " grados centigrados");

    }

}