package bootcamp;

public abstract class Animal {
    public abstract void emitirSonido();

    static void comerAnimal(Animal animal){
        if(animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }else if(animal instanceof Herviboro){
            ((Herviboro) animal).comerHierba();
        }
    }

    public void comerAnimal(){
        if(this instanceof Carnivoro){
            ((Carnivoro) this).comerCarne();
        }else if(this instanceof Herviboro){
            ((Herviboro) this).comerHierba();
        }
    }

}
