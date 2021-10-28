package C4.ejercicioAbstractas;

public class Main {
    public static void main(String[] args) {
        newSerie serieTres = new newSerie(3);
        System.out.println(serieTres.getValorSiguiente());
        System.out.println(serieTres.getValorSiguiente());
        System.out.println(serieTres.getValorSiguiente());
        serieTres.setValorInicial(1);
        System.out.println(serieTres.getValorSiguiente());
        System.out.println(serieTres.getValorSiguiente());
    }
}
