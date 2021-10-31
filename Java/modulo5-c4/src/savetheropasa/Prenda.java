package savetheropasa;

public class Prenda {
    String marca;
    String modelo;

    public Prenda(String inMarca, String inModelo) {
        this.marca = inMarca;
        this.modelo = inModelo;
    }

    @Override
    public String toString() {
        return String.format("Marca: %s - Modelo: %s", this.marca, this.modelo);
    }
}
