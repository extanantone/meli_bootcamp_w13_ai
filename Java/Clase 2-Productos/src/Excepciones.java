public class Excepciones {
    static int a = 0;
    static int b = 300;

    public static void main(String[] args) {
        try{
            double div = b / a;
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede dividir por 0");
        }finally {
            System.out.println("Programa Finalizado");
        }
    }
}
