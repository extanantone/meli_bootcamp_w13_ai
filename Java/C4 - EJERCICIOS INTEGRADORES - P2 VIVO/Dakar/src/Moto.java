public class Moto extends Vehiculo{
    public Moto(){
        this.peso = 300;
        this.ruedas = 2;
    }

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = 300;
        this.ruedas = 2;
    }
}
