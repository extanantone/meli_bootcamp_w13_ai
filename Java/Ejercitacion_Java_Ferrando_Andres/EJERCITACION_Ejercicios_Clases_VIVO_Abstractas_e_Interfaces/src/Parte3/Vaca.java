package Parte3;

public class Vaca extends Animal implements comerHierva{
    @Override
    public String emitirSonido() {
        return "muu";
    }

    @Override
    public void comerHierva() {

        System.out.println("La vaca comio hierva");
    }
}
