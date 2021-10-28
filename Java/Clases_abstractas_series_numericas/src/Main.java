public class Main {
    public static void main(String[] args) {
        serieDos series = new serieDos(0);

        System.out.println(series.siguiente());
        System.out.println(series.siguiente());
        System.out.println(series.siguiente());
        System.out.println(series.siguiente());
        series.resetear();
        series.iniciarEn(11);
        series.resetear();
        System.out.println(series.siguiente());
        System.out.println(series.siguiente());
        System.out.println(series.siguiente());


    }
}
