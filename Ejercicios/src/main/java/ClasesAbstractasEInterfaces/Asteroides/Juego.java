package ClasesAbstractasEInterfaces.Asteroides;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {
    public static void main (String[] args){

        List<Puntuable> entidadesEspaciales = registrarEntidadesEspaciales();
        Scanner scan = new Scanner(System.in);
        String salida = "y";

        while(!salida.equals("n"))
        {
            int[] cordsTarget = definirTarget();

            calcularPuntuacion(entidadesEspaciales,cordsTarget);

            System.out.println("Desea seguir jugando? : y/n");
            salida = scan.nextLine();
        }
        System.out.println("la puntuacion final es: ");
        for(Puntuable entidad:entidadesEspaciales)
        {
            System.out.println("nombre: " + entidad.obtenerIdentificacion() + " Puntuacion: " + entidad.obtenerPuntuacion());
        }

    }

        private static void calcularPuntuacion(List<Puntuable> entidadesEspaciales, int[] cordsTarget) {
            Puntuable masCercana = entidadesEspaciales.get(0);
            double distanciaMasCercana = masCercana.calcularDistancia(cordsTarget[0],cordsTarget[1]);

            for(Puntuable entidad:entidadesEspaciales)
            {
                double distanciaLocal = entidad.calcularDistancia(cordsTarget[0],cordsTarget[1]);
                System.out.println(entidad.obtenerIdentificacion() + " distancia: " +distanciaLocal);
                if(distanciaLocal<distanciaMasCercana)
                {
                    distanciaMasCercana = distanciaLocal;
                    masCercana = entidad;
                }
            }
            masCercana.puntuar();
        }

        private static int[] definirTarget() {
            Scanner scan = new Scanner(System.in);
            System.out.println("coordenada x ");
            int x = scan.nextInt();
            System.out.println("coordenada Y ");
            int y = scan.nextInt();

            return new int[]{x, y};
        }

        private static List<Puntuable> registrarEntidadesEspaciales() {
            List<Puntuable> navesRegistradas = new ArrayList<>();

            Nave nave1 = new Nave("X-Wing",33,333);
            Nave nave2 = new Nave("HalconMilenario",75,1000);
            Nave nave3 = new Nave("Ala-x",15,38);
            Nave nave4 = new Nave("Y-Wing",50,100);

            FlotaDeNaves flota1 = new FlotaDeNaves("flota1");

            flota1.aniadirNave(nave1);
            flota1.aniadirNave(nave2);

            navesRegistradas.add(nave3);
            navesRegistradas.add(nave4);
            navesRegistradas.add(flota1);

            return navesRegistradas;
    }
}
