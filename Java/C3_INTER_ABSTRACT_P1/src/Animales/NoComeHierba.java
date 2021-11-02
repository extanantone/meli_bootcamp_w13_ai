package Animales;

public class NoComeHierba implements HierbaComportamiento
{
    @Override
    public void comerHierba()
    {
        System.out.println("No quiere comer hierba");
    }
}
