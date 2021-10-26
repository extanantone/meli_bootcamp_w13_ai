public class Persona
{
    String nombre;
    byte edad;
    String dni;
    float peso; // Kg
    float altura; // cm

    public Persona()
    {

    }

    public Persona(String nombre, byte edad, String dni)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, byte edad, String dni, float peso, float altura)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC()
    {
       float IMC;
       IMC = this.peso / (this.altura * this.altura);
       if (IMC >= 20 && IMC <= 25)
           return (0);
       else if (IMC < 20)
           return (-1);
       else
           return (1);
    }

    public boolean esMayorDeEdad()
    {
        return (this.edad >= 18);
    }

    @Override
    public String toString()
    {
        return String.format("Nombre: %s\nEdad: %d\nDNI: %s\nPeso: %f\nAltura: %f",
                this.nombre, this.edad, this.dni, this.peso, this.altura);
    }
}
