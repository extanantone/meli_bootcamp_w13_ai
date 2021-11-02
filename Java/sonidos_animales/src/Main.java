
public class Main {
    public static void main (String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonidos();
        gato.emitirSonidos();
        vaca.emitirSonidos();

        System.out.println("\n");


        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();

    }
}
