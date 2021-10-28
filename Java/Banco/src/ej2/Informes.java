package ej2;

public class Informes extends Documentos{
    String texto,autor,revisor;
    int paginas;

    public Informes(String texto, String autor, String revisor, int paginas) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "LibrosPDF{" +
                "texto='" + texto + '\'' +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

