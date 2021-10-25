import java.util.Scanner;
public class Principal {

    public static void main(String args[]){

        //Declaración e inicialización de variables
        int cantidad_ciudades;
        String ciudades[];
        int temperaturas[][];
        int temp_min = 10000, temp_max = 0;
        Scanner teclado = new Scanner(System.in);

        //Se solicita la cantidad de ciudades
        System.out.println("Por favor ingresa la cantidad de ciudades: ");
        cantidad_ciudades = teclado.nextInt();

        //Al usar nextInt() queda en memoria un salto de línea que hay que quemar para que no lo tome el próximo nextline() y lo quemo con teclado.nextLine()
        teclado.nextLine();

        //Inicialización del vector y la matriz
        ciudades = new String[cantidad_ciudades];
        temperaturas = new int[cantidad_ciudades][2];

        //Se solicitan los nombres de todas las ciudades según la cantidad ingresada anteriormente
        for(int i = 0; i < ciudades.length; i++){
            System.out.println("Ingresa el nombre de la ciudad " + (i + 1) + ": ");
            ciudades[i] = teclado.nextLine();
        }

        //Se imprime la lista de ciudades ingresadas
        System.out.println("Las ciudades ingresadas son: ");

        for(int i = 0; i < ciudades.length; i++){
            System.out.println(ciudades[i]);
        }

        //Se solicitan las temperaturas para cada ciudad llenando la matriz Temperaturas
        System.out.println("Por favor ingresa las temperaturas mínima y máxima de cada ciudad: ");
        for(int i = 0; i < temperaturas.length; i++){
            for(int j = 0; j < 2; j++){
                temperaturas[i][j] = teclado.nextInt();
            }
        }

        //Se indica el listado de temperaturas por ciudad
        for(int i = 0; i < temperaturas.length; i++){
            System.out.print("Temperaturas en "+ciudades[i] + " -> mín: ");
            for(int j = 0; j < 2; j++){
                if(j > 0){
                    System.out.print("máx: ");
                }
                System.out.print(temperaturas[i][j] + "\n");
            }

        }

        //Se halla la temperatura mínima
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

        System.out.println("\nLa temperatura mínima de entre todas las ciudades fue de " + temp_min);

        //Se halla la temperatura máxima
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
