package Documentos;

public interface Imprimible
{
    public static void imprimir(Documento documento)
    {
        System.out.println("Imprimiendo");
        System.out.println(documento);
    }
}
