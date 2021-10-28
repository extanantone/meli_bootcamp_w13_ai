import java.util.Arrays;

public class Vehiculo {
    private String modelo,marca;
    private Double costo;

    public Vehiculo(String modelo, String marca, Double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public Double getCosto() {
        return costo;
    }
}
