package autoPartes;

public class Vehiculo {
    private String modelo;
    private String marca;
    private double costo;

    public Vehiculo(String marca, String modelo, double costo) {
        this.modelo = modelo;
        this.marca = marca;
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

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String toString() {
        return String.format("Marca: %s - Modelo: %s - Costo:  %f", this.marca, this.modelo, this.costo);
    }
}
