
public class Vaca extends Animal implements Herbivoro {
    public Vaca() {}

    public void emitirSonidos() {

        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {

        System.out.println("Comiendo hierbas");
    }
}
