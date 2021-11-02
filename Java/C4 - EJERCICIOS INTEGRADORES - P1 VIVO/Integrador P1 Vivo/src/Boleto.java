public class Boleto {
    private int numero;
    private Double precio;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boleto(int numero, Double precio) {
        this.numero = numero;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Boleto - numero: "+ this.numero +" - precio: "+this.precio;
    }
}
