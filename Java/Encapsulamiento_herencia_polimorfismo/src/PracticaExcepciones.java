public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public int sumar (){
        try {
            return this.b/this.a;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por 0");
        }
    }
}
