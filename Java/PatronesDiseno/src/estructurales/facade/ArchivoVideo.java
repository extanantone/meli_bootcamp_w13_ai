package estructurales.facade;

public class ArchivoVideo {

    private String nombre;
    private String tipoCodec;

    public ArchivoVideo(String nombre, String tipoCodec) {
        this.nombre = nombre;
        this.tipoCodec = tipoCodec;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCodec() {
        return tipoCodec;
    }

    public void setTipoCodec(String tipoCodec) {
        this.tipoCodec = tipoCodec;
    }
}
