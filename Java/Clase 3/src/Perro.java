public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonidos() {
        System.out.println("Guauuu");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendoo carne");
    }
}
