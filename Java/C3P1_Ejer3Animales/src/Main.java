public class Main {
    public static void main(String[] args){
        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierba();

        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();
    }
}
