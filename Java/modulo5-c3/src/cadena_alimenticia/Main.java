package cadena_alimenticia;

public class Main {
    public static void main (String[] args) {
        Perro clifford = new Perro();
        Gato felix = new Gato();
        Vaca cora = new Vaca();

        System.out.println("Veamos los sonidos que emiten los animales:");
        clifford.emitirSonidos();
        felix.emitirSonidos();
        cora.emitirSonidos();

        System.out.println("Ahora veamos si respetan sus gustos alimenticios:");
        clifford.comerCarne();
        felix.comerCarne();
        cora.comerHierba();

        // Falta abstraer el método comer para comerCarne y comerHierba
    }
}
