package supermercado;

public class Item {
    private Long codigo;
    private String nombre;
    private Integer cantidad;
    private Double costoUnidad;

    public Item(Long codigo, String nombre, Integer cantidad, Double costoUnidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnidad = costoUnidad;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getCostoUnidad() {
        return costoUnidad;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setCostoUnidad(Double costoUnidad) {
        this.costoUnidad = costoUnidad;
    }
}
