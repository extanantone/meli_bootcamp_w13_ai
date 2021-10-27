package C4;

public class Curriculum extends Documento{

    private String habilidades;
    private String atributos;

    @Override
    public void imprimir() {
        System.out.println("Curriculum: "+habilidades);
    }
}
