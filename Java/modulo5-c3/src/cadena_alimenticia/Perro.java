package cadena_alimenticia;

public class Perro extends Animal implements Carnivoro {
    public Perro() {}

    public void emitirSonidos() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
