import java.util.Scanner;
public class Principal {

    public static void main(String args[]){
        int cantidad_ciudades;
        String ciudades[];
        int temperaturas[][];
        int temp_min = 0, temp_max = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Por favor ingresa la cantidad de ciudades: ");
        cantidad_ciudades = teclado.nextInt();
        teclado.nextLine();
        ciudades = new String[cantidad_ciudades];
        temperaturas = new int[cantidad_ciudades][2];

        for(int i = 0; i < ciudades.length; i++){
            System.out.println("Ingresa el nombre de la ciudad " + (i + 1) + ": ");
            ciudades[i] = teclado.nextLine();
        }

        System.out.println("Las ciudades ingresadas son: ");

        for(int i = 0; i < ciudades.length; i++){
            System.out.println(ciudades[i]);
        }

        System.out.println("Por favor ingresa las temperaturas mínima y máxima de cada ciudad: ");
        for(int i = 0; i < temperaturas.length; i++){
            for(int j = 0; j < 2; j++){
                temperaturas[i][j] = teclado.nextInt();
            }
        }

        for(int i = 0; i < temperaturas.length; i++){
            System.out.print("\n"+ciudades[i] + " -> ");
            for(int j = 0; j < 2; j++){
                System.out.print(temperaturas[i][j] + " ");
            }
        }

        int temp_sig;
        int temp_actual;
        for(int i = 0; i < temperaturas.length; i++){
            for(int j = 0; j < 2; j++){
                temp_actual = temperaturas[i][j];
                if(temp_actual > temp_min){
                    temp_actual = temp_min;
                }
                temp_sig = temperaturas[i][j+1];
                if(temp_actual > temp_sig){
                    temp_min = temp_sig;
                    break;
                }
                temp_min = temp_actual;
                break;
            }
        }

        System.out.println("\nLa temperatura mínima de entre todas las ciudades fue: " + temp_min);

        for(int i = 0; i < temperaturas.length; i++){
            for(int j = 0; j < 2; j++){
                temp_actual = temperaturas[i][j];
                if(temp_max > temp_actual){
                    temp_actual = temp_max;
                }
                temp_sig = temperaturas[i][j+1];
                if(temp_actual < temp_sig){
                    temp_max = temp_sig;
                    break;
                }
                break;
            }
        }

        System.out.println("La temperatura máxima de entre todas las ciudades fue: " + temp_max);
    }
}
