import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        PracticaExcepciones test = new PracticaExcepciones();
//        try{
//            test.sumar();
//        }catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//        }finally {
//            System.out.println("Programa finalizado");
//        }

        Producto arroz = new Producto("Arroz",100);
        Producto leche = new Pereceredo("Leche", 120,2);
        Producto harina = new NoPereceredo("Harina", 180,"Bebida");

        System.out.println(arroz.calcular(5));
        System.out.println(leche.calcular(5));
        System.out.println(harina.calcular(5));

        ArrayList<Producto> lista = new ArrayList<Producto>(Arrays.asList(arroz,leche,harina));
        Distribuidora distribuidora = new Distribuidora(lista);

        distribuidora.vender();
    }
}
