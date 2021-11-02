package Animales;

public class NoComeCarne implements CarneComportamiento
{
    @Override
    public void comerCarne()
    {
        System.out.println("No come carne");
    }
}
