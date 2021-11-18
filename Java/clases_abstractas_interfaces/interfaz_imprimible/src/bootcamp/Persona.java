package bootcamp;

public class Persona {
    private String nombre;
    private Integer edad;
    private Long dni;
    private String domicilio;

    public Persona(String nombre, Integer edad, Long dni, String domicilio) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Persona:\n" +
                "nombre: " + nombre + "\n" +
                "edad: " + edad + "\n" +
                "dni: " + dni + "\n" +
                "domicilio: " + domicilio;
    }
}
