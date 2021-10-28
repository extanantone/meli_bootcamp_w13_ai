public class Main {

    public static void main(String[] args) {

        Prototipo prototipoPrimero = new PrototipoPrimero(2.0);

        Prototipo prototipoSegundo = new PrototipoSegundo(1.0);

        System.out.println("" + prototipoPrimero.devolverValorSerie());
        System.out.println("" + prototipoPrimero.devolverValorSerie());
        System.out.println("" + prototipoPrimero.devolverValorSerie());
        System.out.println("" + prototipoPrimero.devolverValorSerie());

        System.out.println("");

        System.out.println("" + prototipoSegundo.devolverValorSerie());
        System.out.println("" + prototipoSegundo.devolverValorSerie());
        System.out.println("" + prototipoSegundo.devolverValorSerie());
        System.out.println("" + prototipoSegundo.devolverValorSerie());
    }
}
