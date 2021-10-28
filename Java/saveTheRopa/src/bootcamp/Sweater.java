package bootcamp;

public class Sweater extends Prenda{
    public Sweater(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public String toString() {
        return "[Sweater " + super.getMarca() + " - " + super.getModelo() + "]";
    }
}
