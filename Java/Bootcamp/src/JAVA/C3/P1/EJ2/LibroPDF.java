package JAVA.C3.P1.EJ2;

public class LibroPDF extends Documento implements Imprimible{
    private persona autor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantidadPaginas, persona autor) {
        super(cantidadPaginas);
        this.autor = autor;
    }
}
