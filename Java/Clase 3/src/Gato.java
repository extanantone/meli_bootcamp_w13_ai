public class Gato extends Animal implements Carnivoro {
    public Gato() {
    }

    @Override
    public void emitirSonidos() {
        System.out.println("Miauu");
    }


    @Override
    public void comerCarne() {
        System.out.println("Comiendoo carne");
    }
}
