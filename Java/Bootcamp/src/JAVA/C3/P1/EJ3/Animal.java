package JAVA.C3.P1.EJ3;

public abstract class Animal {
    private int tipoAnimal; //1.hervíboro ; 2. carnívoro

    public abstract String emitirSonido();

    public int getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(int tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public Animal(int tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
}
