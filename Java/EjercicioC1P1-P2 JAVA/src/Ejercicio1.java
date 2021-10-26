import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        //creación del objeto que lee lo ingresado por teclado
        Scanner tecla = new Scanner(System.in);

        //declaración vector ciudades
        String ciudades[] = new String[10];
        //inicialización del vector ciudades
        for (int i = 0; i < ciudades.length; i++) {
            System.out.println("Ingresar el valor de la ciudad en la posición: ");
            ciudades[i] = tecla.nextLine();
        }
        //recorrido del vector ciudades
        for (int i = 0; i < ciudades.length; i++) {
            System.out.println("Ciudad: " + ciudades[i] + ", en la posición: " + i);
        }

        //declaración del array temperaturas
        int temperaturas[][] = new int[10][2];
        //inicialización del array temperaturas
        for (int f = 0; f < temperaturas.length; f++) { //f<temperaturas.length = f<=9
            for (int i = 0; i < temperaturas[0].length; i++) { //i<temperaturas[0].length = i <= 1
                System.out.println("Ingresar el valor de la temperatura en la posición: " + f + ", " + i);
                temperaturas[f][i] = tecla.nextInt();
            }
        }
        //recorrido del array temperaturas
        for (int f = 0; f < temperaturas.length; f++) {
            for (int i = 0; i < temperaturas[0].length; i++) {
                System.out.println("Fila: " + f + ", Columna: " + i);
                System.out.println("Tengo guardada la temperatura: " + temperaturas[f][i]);
            }
        }

        //lógica menor y mayor temperatura + ciudad
        int temperaturaMenor = temperaturas[0][0];
        String ciudadMenorTemperatura = ciudades[0];
        String ciudadMayorTemperatura = ciudades[0];
        int temperaturaMayor = temperaturas[0][0];
        for (int f = 0; f < temperaturas.length; f++) {
            for (int i = 0; i < temperaturas[0].length; i++) {
                if (temperaturaMenor <= temperaturas[f][i]) {
                    temperaturaMenor = temperaturas[f][i];
                    ciudadMenorTemperatura = ciudades[f];
                }
                if (temperaturaMayor >= temperaturas[f][i]) {
                    temperaturaMayor = temperaturas[f][i];
                    ciudadMayorTemperatura = ciudades[f];
                }
            }
        }

        //salida final del sistema
        System.out.println("La menor temperatura la tuvo " + ciudadMenorTemperatura + ", con " + temperaturaMenor + " º C.");
        System.out.println("La mayor temperatura la tuvo " + ciudadMayorTemperatura + ", con " + temperaturaMayor + " º C.");
    }
}
