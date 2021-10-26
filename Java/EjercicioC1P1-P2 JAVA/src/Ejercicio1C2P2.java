public class Ejercicio1C2P2 {
    public static void main(String[] args) {
        PracticaExcepciones p = new PracticaExcepciones();
        try {
            p.calcularCociente();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado.");
        }
    }
}
