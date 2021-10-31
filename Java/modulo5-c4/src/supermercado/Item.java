package supermercado;

public class Item {
    private int codigo;
    private String nombre;
    private double costoUnitario;

    public Item(int inCodigo, String inNombre, double inCostoUnitario) {
        this.codigo = inCodigo;
        this.nombre = inNombre;
        this.costoUnitario = inCostoUnitario;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String inNombre) {
        this.nombre = inNombre;
    }

    public double getCostoUnitario() {
        return this.costoUnitario;
    }

    public void setCostoUnitario(double inCostoUnitario) {
        this.costoUnitario = inCostoUnitario;
    }
}
