package Ejercicio2;

public class LibroPDF extends TipoDocumento implements Documentos{
    String texto;
    String nombreRevisor;

    public LibroPDF(String nombreAutor, String apellidoAutor, int precio, int cantidadDePaginas, String texto, String nombreRevisor) {
        super(nombreAutor, apellidoAutor, precio, cantidadDePaginas);
        this.texto = texto;
        this.nombreRevisor = nombreRevisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Informacion del informe: \n * Nombre: " + TipoDocumento.nombreAutor);
    }
}
