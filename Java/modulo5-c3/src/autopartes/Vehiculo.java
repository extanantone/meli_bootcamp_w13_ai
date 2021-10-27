package autopartes;

public class Vehiculo {
    private String marca;
    private String modelo;
    private double costo;

    public Vehiculo(String inMarca, String inModelo, double inCosto) {
        this.marca = inMarca;
        this.modelo = inModelo;
        this.costo = inCosto;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String inModelo) {
        this.modelo = inModelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String inMarca) {
        this.marca = inMarca;
    }

    public double getCosto() {
        return this.costo;
    }

    public void setCosto(double inCosto) {
        this.costo = inCosto;
    }

    @Override
    public String toString() {
        return String.format("Marca: %s - Modelo: %s - Costo:  %f", this.marca, this.modelo, this.costo);
    }
}
