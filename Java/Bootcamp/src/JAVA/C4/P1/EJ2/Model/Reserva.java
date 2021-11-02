package JAVA.C4.P1.EJ2.Model;

public abstract class Reserva {
    private int codigo;
    private String nombreEmpresa;
    private double precioUnitario;
    private int cantidad;

    public Reserva(int codigo, String nombreEmpresa, double precioUnitario, int cantidad) {
        this.codigo = codigo;
        this.nombreEmpresa = nombreEmpresa;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo=" + codigo +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", cantidad=" + cantidad +
                '}';
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
