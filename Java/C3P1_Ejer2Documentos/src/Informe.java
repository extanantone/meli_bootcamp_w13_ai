public class Informe extends Documento{
    int cantPaginas;
    String autor;
    String revisor;
    String texto;

    public Informe(int cantPaginas, String autor, String revisor, String texto) {
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "cantPaginas=" + cantPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}
