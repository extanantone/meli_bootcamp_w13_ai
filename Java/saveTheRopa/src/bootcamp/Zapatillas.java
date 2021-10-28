package bootcamp;

public class Zapatillas extends Prenda{
    public Zapatillas(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public String toString() {
        return "[Zapatillas " + super.getMarca() + " - " + super.getModelo() + "]";
    }
}
