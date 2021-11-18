package bootcamp;

public class LibroPDF implements Imprimible{
    private Integer cantPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(Integer cantPaginas, String autor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir(){
        System.out.println("---- PDF ----");
        System.out.println("Genero: " + this.genero);
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Cantidad de paginas: " + this.cantPaginas);
    }
}
