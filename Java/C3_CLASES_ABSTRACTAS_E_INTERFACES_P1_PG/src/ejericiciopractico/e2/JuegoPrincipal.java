package ejericiciopractico.e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JuegoPrincipal {

    public static void main(String[] args) {

        // registrar naves y flotas
        List<Puntuable> entidadesEspaciales = registrarEntidadesEspaciales();
        Scanner scan = new Scanner(System.in);
        String salida = "y";

        while(!salida.equals("n"))
        {
            int[] cordsTarget = definirTarget();

            // calcular puntuaciones da un punto a la entidad msa cercana
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
        // definir targets
        System.out.println("defina la coordenada x del tarjet ");
        int xTarget = scan.nextInt();
        System.out.println("defina la coordenada Y del tarjet ");
        int yTarget = scan.nextInt();

        return new int[]{xTarget, yTarget};
    }

    private static List<Puntuable> registrarEntidadesEspaciales() {
        List<Puntuable> navesRegistradas = new ArrayList<>();

        NaveSimple nave1 = new NaveSimple("rocky",100,100);
        NaveSimple nave2 = new NaveSimple("rocky1",80,100);
        NaveSimple nave3 = new NaveSimple("rocky2",70,100);
        NaveSimple nave4 = new NaveSimple("rocky3",60,100);

        CompositeFlota flota1 = new CompositeFlota("flota1");

        flota1.anadirNave(nave1);
        flota1.anadirNave(nave2);

        navesRegistradas.add(nave3);
        navesRegistradas.add(nave4);
        navesRegistradas.add(flota1);

        return navesRegistradas;

    }

}
