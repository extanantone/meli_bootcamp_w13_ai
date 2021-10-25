public class Carrera {

    private static int nextCarrera = 0;
    private int codigoCarrera;
    private String nombreCategoria;

    public Carrera(String nombreCategoria) {
        nextCarrera++;
        this.codigoCarrera = nextCarrera;
        this.nombreCategoria = nombreCategoria;
    }

    public int getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
