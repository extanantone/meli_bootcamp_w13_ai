package Animales;

public abstract class Animal
{
    HierbaComportamiento hierbaComportamiento;
    CarneComportamiento carneComportamiento;

    public void comerHierba()
    {
        hierbaComportamiento.comerHierba();
    }

    public void comerCarne()
    {
        carneComportamiento.comerCarne();
    }

    public void comerAnimal(Animal comida)
    {
        System.out.printf("Comiendose un %s\n", comida.getClass().getName());
    }

    public abstract void emitirSonido();
}
