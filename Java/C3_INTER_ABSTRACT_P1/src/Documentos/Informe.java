package Documentos;

import java.util.StringJoiner;

public class Informe
{
    String texto;
    String autor;
    String revisor;

    @Override
    public String toString()
    {
        return new StringJoiner(", ", Informe.class.getSimpleName() + "[", "]")
                .add("texto='" + texto + "'")
                .add("autor='" + autor + "'")
                .add("revisor='" + revisor + "'")
                .add("cantidadPaginas=" + cantidadPaginas)
                .toString();
    }

    public Informe(String texto, String autor, String revisor, int cantidadPaginas)
    {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getTexto()
    {
        return texto;
    }

    public void setTexto(String texto)
    {
        this.texto = texto;
    }

    public String getAutor()
    {
        return autor;
    }

    public void setAutor(String autor)
    {
        this.autor = autor;
    }

    public String getRevisor()
    {
        return revisor;
    }

    public void setRevisor(String revisor)
    {
        this.revisor = revisor;
    }

    public int getCantidadPaginas()
    {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas)
    {
        this.cantidadPaginas = cantidadPaginas;
    }

    int cantidadPaginas;
}
