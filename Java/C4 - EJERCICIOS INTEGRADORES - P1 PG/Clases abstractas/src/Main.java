public class Main {
    public static void main(String[] args) {
        SerieInteger serieInteger = new SerieInteger(2);
        System.out.println("-----Serie Integer 2, valor inicial 0 ------");
        System.out.println(serieInteger.siguiente());
        System.out.println(serieInteger.siguiente());
        System.out.println(serieInteger.siguiente());
        System.out.println("----------------------------------\n");

        System.out.println("-----Serie Integer 2, valor inicial 1 ------");
        serieInteger.valorInicial(1);
        serieInteger.reiniciar();
        System.out.println(serieInteger.siguiente());
        System.out.println(serieInteger.siguiente());
        System.out.println(serieInteger.siguiente());
        System.out.println("----------------------------------\n");

        System.out.println("-----Serie Double 3, valor inicial 0 ------");
        SerieDouble serieDouble3 = new SerieDouble(3.0);
        System.out.println(serieDouble3.siguiente());
        System.out.println(serieDouble3.siguiente());
        System.out.println(serieDouble3.siguiente());
        System.out.println("----------------------------------\n");
    }
}
