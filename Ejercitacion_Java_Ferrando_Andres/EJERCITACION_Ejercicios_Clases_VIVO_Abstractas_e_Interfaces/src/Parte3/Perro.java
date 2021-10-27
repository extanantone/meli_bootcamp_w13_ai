package Parte3;

public class Perro extends Animal implements comerCarne{
    @Override
    public String emitirSonido() {
        return "guau";
    }

    @Override
    public void comerCarne() {

        System.out.println("El perro comio carne");
    }
}
