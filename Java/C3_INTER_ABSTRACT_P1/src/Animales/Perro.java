package Animales;

public class Perro extends Animal
{
    @Override
    public void emitirSonido()
    {
        System.out.println("Guau");
    }

    public Perro()
    {
        hierbaComportamiento = new NoComeHierba();
        carneComportamiento = new ComeCarne();
    }
}
