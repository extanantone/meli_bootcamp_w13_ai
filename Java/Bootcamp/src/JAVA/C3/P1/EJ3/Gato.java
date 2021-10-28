package JAVA.C3.P1.EJ3;

public class Gato extends Animal {
    private boolean tieneCascabel;

    @Override
    public String emitirSonido() {
        return "Miau!";
    }

    public Gato(boolean tieneCascabel) {
        super(2);
        this.tieneCascabel = tieneCascabel;
    }
}
