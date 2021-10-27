package Parte3;

public class Gato extends Animal implements comerCarne{
    @Override
    public String emitirSonido() {
        return "miau";
    }

    @Override
    public void comerCarne() {

        System.out.println("El gato comio carne");
    }
}
