package bootcamp;

public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonido() {
        System.out.println("muuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Soy una vaca comiendo pasto");
    }
}
