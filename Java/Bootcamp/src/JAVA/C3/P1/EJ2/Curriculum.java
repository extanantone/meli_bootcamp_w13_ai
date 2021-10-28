package JAVA.C3.P1.EJ2;

public class Curriculum extends Documento implements Imprimible{
    private persona p;

    public Curriculum(int cantidadPaginas, persona p) {
        super(cantidadPaginas);
        this.p = p;
    }
}
