package bootcamp;

public class Campera extends Prenda{
    public Campera(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public String toString() {
        return "[Campera " + super.getMarca() + " - " + super.getModelo() + "]";
    }
}
