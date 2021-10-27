
public class Main {
    public static void main(String[] args) {
        Perro max = new Perro();
        Gato power = new Gato();
        Vaca homer = new Vaca();

        max.emitirSonidos();
        power.emitirSonidos();
        homer.emitirSonidos();

        max.comerCarne();
        power.comerCarne();
        homer.comerHierba();

    }
}
