package herencia;

import java.util.concurrent.ThreadLocalRandom;

public class Distribuidora {
    public static void main (String[] args){
        int randomNum;
        Perecedero p1= new Perecedero(2,"leche", 12500);
        Perecedero p2= new Perecedero(1,"pollo", 10400);
        Perecedero p3= new Perecedero(2,"pescado", 8100);
        Perecedero p4= new Perecedero(3,"banano", 12500);
        Perecedero p5= new Perecedero(2,"sandia", 5700);
        NoPerecedero p6= new NoPerecedero("arvejas",800, "enlatado");
        NoPerecedero p7= new NoPerecedero("lentejas",2000, "empaquetado");
        NoPerecedero p8= new NoPerecedero("frijoles",2500, "empaquetado");
        NoPerecedero p9= new NoPerecedero("aceite",5000, "empaquetado");
        NoPerecedero p10= new NoPerecedero("salchicha",3000, "enlatado");
        Producto[] productos = new Producto[]{p1, p2, p3, p4, p5,p6, p7, p8, p9, p10};
        for (Producto p:productos) {
            randomNum = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            System.out.println(p.toString());
            System.out.println("Precio final: "+p.calcular(randomNum));
        }

    }

}
