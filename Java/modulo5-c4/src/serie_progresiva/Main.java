package serie_progresiva;

public class Main {
    public static void main(String[] args) {
        SerieProgresiva<Integer> serieDeDos = new SerieProgresivaInt(2);
        System.out.println("Valores siguientes de serie de 2:");
        for (int i = 0; i < 4; i++)  System.out.println(serieDeDos.siguienteValor());
        System.out.println("Valores siguientes tras establecer valor inicial en 1:");
        serieDeDos.setValorInicial(1);
        for (int i = 0; i < 4; i++)  System.out.println(serieDeDos.siguienteValor());
        System.out.println("Valores siguientes de serie de 3.0:");
        SerieProgresiva<Double> serieDeTres = new SerieProgresivaDouble(3.0);
        for (int i = 0; i < 4; i++)  System.out.println(serieDeTres.siguienteValor());
    }
}
