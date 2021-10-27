package ejericiciopractico.e2;

public class Main {
    public static void main(String[] args) {
        Serie2<Integer> serie2 = new Serie2<>();
        Serie3<Float> serie3 = new Serie3<>();
        Serie3<Byte> serie4 = new Serie3<>();
        serie2.setValorInicial(0);
        serie3.setValorInicial((float) 0);
        serie4.setValorInicial((byte) 0);

        for (int i = 0; i < 10; i++) {
            System.out.println(serie2.valorSiguiente());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(serie3.valorSiguiente());
            if (i == 5)
                serie3.reiniciarSerie();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(serie4.valorSiguiente());
            if (i == 5)
                serie4.reiniciarSerie();

        }
    }
}
