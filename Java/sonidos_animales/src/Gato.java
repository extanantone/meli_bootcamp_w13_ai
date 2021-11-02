
public class Gato extends Animal implements Carnivoro {
    public Gato() {}

    public void emitirSonidos() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
