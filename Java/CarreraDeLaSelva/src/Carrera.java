public class Carrera {

    private static int nextCarrera = 0;
    private int codigoCarrera;
    private String nombreCategoria;
    private int minEdad;
    private int maxEdad;
    private int montoMayores;
    private int montoMenores;

    public Carrera(String nombreCategoria, int minEdad, int maxEdad, int montoMenores, int montoMayores) {
        nextCarrera++;
        this.codigoCarrera = nextCarrera;
        this.nombreCategoria = nombreCategoria;
        this.minEdad = minEdad;
        this.maxEdad = maxEdad;
        this.montoMenores = montoMenores;
        this.montoMayores = montoMayores;
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

    public static int getNextCarrera() {
        return nextCarrera;
    }

    public static void setNextCarrera(int nextCarrera) {
        Carrera.nextCarrera = nextCarrera;
    }

    public int getMinEdad() {
        return minEdad;
    }

    public void setMinEdad(int minEdad) {
        this.minEdad = minEdad;
    }

    public int getMaxEdad() {
        return maxEdad;
    }

    public void setMaxEdad(int maxEdad) {
        this.maxEdad = maxEdad;
    }

    public int getMontoMayores() {
        return montoMayores;
    }

    public void setMontoMayores(int montoMayores) {
        this.montoMayores = montoMayores;
    }

    public int getMontoMenores() {
        return montoMenores;
    }

    public void setMontoMenores(int montoMenores) {
        this.montoMenores = montoMenores;
    }
}
