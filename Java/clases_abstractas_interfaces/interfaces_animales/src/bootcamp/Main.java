package bootcamp;

public class Main {

    public static void main(String[] args) {
        Animal animal;
        animal = new Perro();
        animal.emitirSonido();
        ((Carnivoro) animal).comerCarne();
        Animal.comerAnimal(animal);

        animal = new Gato();
        animal.emitirSonido();
        ((Carnivoro) animal).comerCarne();
        animal.comerAnimal();

        Gato gato = new Gato();
        gato.comerAnimal();

        animal = new Vaca();
        animal.emitirSonido();
        ((Herviboro) animal).comerHierba();

        Animal.comerAnimal(animal);
    }
}
