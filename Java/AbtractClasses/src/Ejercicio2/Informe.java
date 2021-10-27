package Ejercicio2;

public class Informe extends TipoDocumento implements Documentos{
    String texto;
    String nombreRevisor;

    public Informe(String nombreAutor, String apellidoAutor, int precio, int cantidadDePaginas, String texto, String nombreRevisor) {
        super(nombreAutor, apellidoAutor, precio, cantidadDePaginas);
        this.texto = texto;
        this.nombreRevisor = nombreRevisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Informacion del informe: \n * Nombre: " + TipoDocumento.nombreAutor);
    }
}
