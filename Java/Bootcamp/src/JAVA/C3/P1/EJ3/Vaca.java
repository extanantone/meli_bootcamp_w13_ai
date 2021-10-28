package JAVA.C3.P1.EJ3;

public class Vaca extends Animal {
    private boolean daLeche;

    @Override
    public String emitirSonido() {
        return "Muu!";
    }

    public Vaca(boolean daLeche) {
        super(1);
        this.daLeche = daLeche;
    }
}
