package Factura;

public class Cliente
{
    private Long dni;
    private String nombre;
    private String apellido;

    public Long getDni()
    {
        return dni;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("dni='").append(dni).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setDni(Long dni)
    {
        this.dni = dni;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public Cliente(Long dni, String nombre, String apellido)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

}

