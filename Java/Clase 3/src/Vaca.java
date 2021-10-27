public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonidos() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendoo Hierba");
    }
}
