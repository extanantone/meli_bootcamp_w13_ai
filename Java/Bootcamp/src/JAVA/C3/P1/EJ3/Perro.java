package JAVA.C3.P1.EJ3;

public class Perro extends Animal {
    private boolean tieneCorrea;

    @Override
    public String emitirSonido() {
        return "Bark bark!";
    }

    public Perro(boolean tieneCorrea) {
        super(2);
        this.tieneCorrea = tieneCorrea;
    }
}
