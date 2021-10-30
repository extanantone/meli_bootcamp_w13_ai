package Java_IV;

// Terminado

public class Main {
    public static void main(String[] args) {
        //Crea los repos
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        RepositorioLocalizadores repositorioLocalizador = new RepositorioLocalizadores();

        //Crea los descuentos
        Descuentos descuentos = new Descuentos(repositorioLocalizador);

        // Agrega cliente
        Cliente cliente1 = new Cliente("38777371", "Señor cliente");
        repositorioCliente.addCliente(cliente1);

        //Crea un localizador full
        Localizador localizador1 = new Localizador(cliente1);
        repositorioLocalizador.addLocalizador(localizador1);

        localizador1.addReserva(new Reserva(TipoReserva.HOTEL, 500));
        localizador1.addReserva(new Reserva(TipoReserva.COMIDA, 200));
        localizador1.addReserva(new Reserva(TipoReserva.TRANSPORTE, 100));
        localizador1.addReserva(new Reserva(TipoReserva.BOLETOS, 400));
        System.out.println(localizador1);
        localizador1.setTotal(descuentos.aplicarDescuentos(localizador1));
        System.out.println(localizador1);

        // Crea un localizador nuevo para el cliente anterior
        Localizador localizador2 = new Localizador(cliente1);
        repositorioLocalizador.addLocalizador(localizador2);

        localizador2.addReserva(new Reserva(TipoReserva.HOTEL, 500));
        localizador2.addReserva(new Reserva(TipoReserva.HOTEL, 500));
        localizador2.addReserva(new Reserva(TipoReserva.BOLETOS, 300));
        localizador2.addReserva(new Reserva(TipoReserva.BOLETOS, 300));
        System.out.println(localizador2);
        localizador2.setTotal(descuentos.aplicarDescuentos(localizador2));
        System.out.println(localizador2);

        // Crea un localizador con una sola reserva
        Localizador localizador3 = new Localizador(cliente1);
        repositorioLocalizador.addLocalizador(localizador3);

        localizador3.addReserva(new Reserva(TipoReserva.COMIDA, 250));
        System.out.println(localizador3);
        localizador3.setTotal(descuentos.aplicarDescuentos(localizador3));
        System.out.println(localizador3);


    }
}
