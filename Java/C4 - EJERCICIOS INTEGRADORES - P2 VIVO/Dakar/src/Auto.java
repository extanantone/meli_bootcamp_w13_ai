public class Auto extends Vehiculo{
    public Auto(){
        this.peso = 1000;
        this.ruedas = 4;
    }

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = 1000;
        this.ruedas = 4;
    }
}
