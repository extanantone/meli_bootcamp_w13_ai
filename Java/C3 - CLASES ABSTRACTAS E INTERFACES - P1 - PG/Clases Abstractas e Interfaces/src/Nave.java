public class Nave extends ObjetoJuego{
    private String nombre;
    private Coordenadas coordenadas;
    private double puntuacion;

    public Nave(){}

    public Nave(String nombre, Coordenadas coordenadas) {
        this.nombre = nombre;
        this.coordenadas = coordenadas;
        this.puntuacion = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public double calcularDistancia(double x, double y) {
        double puntuacion = this.coordenadas.getPosX() - x + this.coordenadas.getPosY() - y;
        return Math.abs(puntuacion);
    }
}
