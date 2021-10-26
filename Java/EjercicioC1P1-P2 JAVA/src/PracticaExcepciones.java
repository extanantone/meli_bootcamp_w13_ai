public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public int calcularCociente() {
        if (a == 0) {
            throw new IllegalArgumentException("No se puede dividir por 0");
        } else {
            return b / a;
        }

    }

}
