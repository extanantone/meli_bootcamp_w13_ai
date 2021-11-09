package estructurales.adapter;

public class MainAdapter {
    public static void main(String[] args) {
        // en el lciente que consume los objetos no se usa directamente el cadrado sino se usa su adaptador alrededdor de el

        PiezaRedonda redonda = new PiezaRedonda(1.0);
        HuecoRedondo hueco = new HuecoRedondo(2);
        PiezaCuadrada cuadrado = new PiezaCuadrada(2.0,3.0);
        PiezaCuadradaAdaptador adapterCuadrado = new PiezaCuadradaAdaptador(cuadrado);

        hueco.probarCabe(redonda);

        hueco.probarCabe(adapterCuadrado);

    }
}
