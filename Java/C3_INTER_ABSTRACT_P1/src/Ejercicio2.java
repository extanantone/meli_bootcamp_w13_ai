import Documentos.*;

import java.util.List;

public class Ejercicio2
{
    public static void main(String[] args)
    {
        String[] skills = {"trabajador", "honesto"};
        Documento notas = new PdfBook(1, "David", "Notas corte 1", "Academico");
        Documento curriculum = new Curriculum(skills);
        Imprimible.imprimir(notas);
        Imprimible.imprimir(curriculum);

    }
}
