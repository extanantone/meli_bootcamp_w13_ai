package estructurales.flyweight.casoexito;

import java.awt.*;

public class MainFlyweight {

    private static final int CANVAS_SIZE = 500;
    private static final int ARBOLES_A_DIBUJAR = 1000000;
    private static final int TIPOS_DE_ARBOLES = 2;

    public static void main(String[] args) {
        Bosque bosque = new Bosque();

        double totales = Math.floor(ARBOLES_A_DIBUJAR/TIPOS_DE_ARBOLES);

        for(int i= 0;i<totales;i++)
        {
            bosque.agregarArbol(random(0,CANVAS_SIZE),random(0,CANVAS_SIZE),"Roble Veraniego", Color.GREEN,"Roble textura verde");
            bosque.agregarArbol(random(0,CANVAS_SIZE),random(0,CANVAS_SIZE),"Roble Otoñal", Color.ORANGE,"Roble textura seca");
        }

        bosque.setSize(CANVAS_SIZE,CANVAS_SIZE);
        bosque.setVisible(true);

        System.out.println(ARBOLES_A_DIBUJAR + " trees drawn");
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Tree size (8 bytes) * " + ARBOLES_A_DIBUJAR);
        System.out.println("+ TreeTypes size (~30 bytes) * " + TIPOS_DE_ARBOLES + "");
        System.out.println("---------------------");
        System.out.println("Total: " + ((ARBOLES_A_DIBUJAR * 8 + TIPOS_DE_ARBOLES * 30) / 1024 / 1024) +
                "MB (instead of " + ((ARBOLES_A_DIBUJAR * 38) / 1024 / 1024) + "MB)");


    }



    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
