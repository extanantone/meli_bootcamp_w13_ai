package Ejercicio2;

public abstract class TipoDocumento {
    static String nombreAutor;
    static String apellidoAutor;
    static int precio;
    static int cantidadDePaginas;

    public TipoDocumento(String nombreAutor, String apellidoAutor, int precio, int cantidadDePaginas) {
        TipoDocumento.nombreAutor = nombreAutor;
        TipoDocumento.apellidoAutor = apellidoAutor;
        TipoDocumento.precio = precio;
        TipoDocumento.cantidadDePaginas = cantidadDePaginas;
    }
}
