public class PracticaExcepciones
{
    public static void main(String[] args)
    {
        int a = 0;
        int b = 300;
        float cociente = 0;

        try
        {
            cociente = b / a;
        }
        catch (ArithmeticException error)
        {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        finally
        {
            System.out.println("Programa finalizado");
        }
        System.out.printf("valor del cociente %f", cociente);
    }
}
