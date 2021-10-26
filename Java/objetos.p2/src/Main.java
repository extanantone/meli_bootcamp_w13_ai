public class Main {

    public static void main(String[] args) {
        PracticaExcepciones test = new PracticaExcepciones(0, 300);
        try {
            test.division();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
