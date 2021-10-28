package productos;

public class TipoProducto {

    private int tipoProducto;
    private String desc;

    public TipoProducto(int tipoProducto, String desc) {
        this.tipoProducto = tipoProducto;
        this.desc = desc;
    }

    public TipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "TipoProducto{" +
                "tipoProducto=" + tipoProducto +
                ", desc='" + desc + '\'' +
                '}';
    }
}
