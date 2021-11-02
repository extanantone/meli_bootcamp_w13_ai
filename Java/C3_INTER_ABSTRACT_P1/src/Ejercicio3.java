import Animales.*;

public class Ejercicio3
{
    public static void main(String[] args)
    {
        Animal ladridos = new Perro();
        Animal gato = new Gato();

        ladridos.emitirSonido();
        ladridos.comerHierba();
        ladridos.comerCarne();

        gato.comerAnimal(ladridos);

    }
}
