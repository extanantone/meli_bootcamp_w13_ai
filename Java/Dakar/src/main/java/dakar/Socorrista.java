package dakar;

public abstract class Socorrista {
    private String patente;
    private Double velocidadSocorro;

    public Socorrista(String patente, Double velocidadSocorro) {
        this.patente = patente;
        this.velocidadSocorro = velocidadSocorro;
    }

    public String getPatente() {
        return patente;
    }

    public Double getVelocidadSocorro() {
        return velocidadSocorro;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setVelocidadSocorro(Double velocidadSocorro) {
        this.velocidadSocorro = velocidadSocorro;
    }
    public abstract void socorrer(Vehiculo vehiculo);
}
