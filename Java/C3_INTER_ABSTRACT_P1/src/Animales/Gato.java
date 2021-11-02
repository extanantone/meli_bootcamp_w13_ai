package Animales;

public class Gato extends Animal
{
    @Override
    public void emitirSonido()
    {
        System.out.println("Miau");
    }

    public Gato()
    {
        hierbaComportamiento = new NoComeHierba();
        carneComportamiento = new ComeCarne();
    }
}
