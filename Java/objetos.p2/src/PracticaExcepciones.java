public class PracticaExcepciones {

    private int a;
    private int b;

    public void division() throws IllegalArgumentException {
        try {
            System.out.println(this.getB()/this.getA());
        }  catch (Exception e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
    }

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
