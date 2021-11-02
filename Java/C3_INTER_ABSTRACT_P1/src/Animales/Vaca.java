package Animales;


public class Vaca extends Animal
{

    public Vaca()
    {
        hierbaComportamiento = new ComeHierba();
        carneComportamiento = new NoComeCarne();
    }

    @Override
    public void emitirSonido()
    {
        System.out.println("Muuu");
    }
}
