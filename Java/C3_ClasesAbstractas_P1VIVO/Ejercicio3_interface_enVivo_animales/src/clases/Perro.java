package clases;

public class Perro extends Animal implements Carnivoro{

    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void comerCarne() {
        System.out.println("Que rica esta esta carne");
    }

    public void emitirSonido(){
        System.out.println("Wof wof");
    }


}
