package Java_IV_b.GuardaRopa;

public class Prenda {
    String marca;
    String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Prenda || " +
                "marca: '" + marca + '\'' +
                ", modelo:'" + modelo + '\''
                ;
    }
}
