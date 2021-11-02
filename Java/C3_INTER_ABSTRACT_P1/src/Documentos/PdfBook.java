package Documentos;

public class PdfBook extends Documento
{
    int cantidadPaginas;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("PdfBook{");
        sb.append("cantidadPaginas=").append(cantidadPaginas);
        sb.append(", autor='").append(autor).append('\'');
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", genero='").append(genero).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public PdfBook(int cantidadPaginas, String autor, String titulo, String genero)
    {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadPaginas()
    {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas)
    {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getAutor()
    {
        return autor;
    }

    public void setAutor(String autor)
    {
        this.autor = autor;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    String autor;
    String titulo;
    String genero;
}
