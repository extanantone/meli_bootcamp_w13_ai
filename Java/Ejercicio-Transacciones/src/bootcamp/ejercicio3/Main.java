package bootcamp.ejercicio3;

public class Main {


    public static void main(String[] args) {

        Perro firu = new Perro();
        Gato michi = new Gato();
        Vaca vaca = new Vaca();

        comer(firu);
        comer(michi);
        comer(vaca);
    }


    public static void comer(Animal animalito){
        animalito.comerAnimal();
    }


}
