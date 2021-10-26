package bootcamp;

public class Gato extends Animal {
    private String nombre;

    public Gato(String especie, String nombre) {
        super(especie);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrarEspecie() {
        super.mostrarEspecie();
        System.out.println("Soy un gato que mauya");
    }

    @Override
    public void hacerSonido() {
        System.out.println("Miau!!");
    }
}