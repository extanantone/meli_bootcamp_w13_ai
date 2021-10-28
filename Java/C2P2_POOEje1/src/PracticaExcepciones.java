public class PracticaExcepciones {
    private int a;
    private int b;

    public PracticaExcepciones() {
        this.a = 0;
        this.b = 300;
    }

    public void calcularCociente(){

        try {
            int cociente = this.b / this.a;
        }catch (ArithmeticException e){
            System.out.println("Se ha producido un error.");
        }finally {
            System.out.println("Programa finalizado");
        }

    }

    public void calcularCocienteMod(){
        try {
            if( this.a == 0 ){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}
