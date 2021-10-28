package JAVA.C3.P1.EJ2;

public class Informe extends Documento implements Imprimible{
    private int longitudTexto;
    private persona autor;
    private persona revisor;

    public Informe(int cantidadPaginas, int longitudTexto, persona autor, persona revisor) {
        super(cantidadPaginas);
        this.longitudTexto = longitudTexto;
        this.autor = autor;
        this.revisor = revisor;
    }
}
