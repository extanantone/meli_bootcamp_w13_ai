package Documentos;

import java.util.Arrays;
import java.util.StringJoiner;

public class Curriculum extends Documento
{
    String[] listaHabilidades;

    @Override
    public String toString()
    {
        return new StringJoiner(", ", Curriculum.class.getSimpleName() + "[", "]")
                .add("listaHabilidades=" + Arrays.toString(listaHabilidades))
                .toString();
    }

    public String[] getListaHabilidades()
    {
        return listaHabilidades;
    }

    public void setListaHabilidades(String[] listaHabilidades)
    {
        this.listaHabilidades = listaHabilidades;
    }

    public Curriculum(String[] listaHabilidades)
    {
        this.listaHabilidades = listaHabilidades;
    }
}
