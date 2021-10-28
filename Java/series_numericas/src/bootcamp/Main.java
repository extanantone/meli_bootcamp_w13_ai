package bootcamp;

public class Main {

    public static void main(String[] args) {

        SerieProgresiva serie2 = new SerieDe2(0);
        System.out.println(serie2.getValorSiguiente());
        System.out.println(serie2.getValorSiguiente());
        System.out.println(serie2.getValorSiguiente());
        System.out.println(serie2.getValorSiguiente());
        System.out.println(serie2.getValorSiguiente());

        System.out.println("--------");

        serie2.setValorInicial(100);
        serie2.reiniciarSerie();
        System.out.println(serie2.getValorSiguiente());
        System.out.println(serie2.getValorSiguiente());
        System.out.println(serie2.getValorSiguiente());
        System.out.println(serie2.getValorSiguiente());

        System.out.println("\n------------------\n");

        SerieDe3 serie3 = new SerieDe3(4);
        System.out.println(serie3.getValorSiguiente());
        System.out.println(serie3.getValorSiguiente());
        System.out.println(serie3.getValorSiguiente());
        System.out.println(serie3.getValorSiguiente());
        System.out.println("--------");
        serie3.setValorInicial(5);
        serie3.reiniciarSerie();
        System.out.println(serie3.getValorSiguiente());
        System.out.println(serie3.getValorSiguiente());
        System.out.println(serie3.getValorSiguiente());
        System.out.println(serie3.getValorSiguiente());
    }
}
