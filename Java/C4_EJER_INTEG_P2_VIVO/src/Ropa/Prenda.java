package Ropa;

public class Prenda
{
    private String marca;
    private String modelo;

    public Prenda(String marca, String modelo)
    {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public String getModelo()
    {
        return modelo;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Prenda{");
        sb.append("marca='").append(marca).append('\'');
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }
}
