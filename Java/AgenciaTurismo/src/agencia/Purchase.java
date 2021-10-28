package agencia;

import java.util.List;
import java.util.stream.Collectors;

public class Purchase {

    private static int currentId;
    private final int id;
    private List<Reservation> reservations;
    private List<Product> products;
    private double totalPrice;
    private Client client;

    public Purchase(List<Reservation> reservations, List<Product> products, Client client) {
        this.id = currentId + 1;
        currentId ++;
        this.reservations = reservations;
        this.products = products;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double calculateTotalPrice() {
        double discount = 0.0;
        if (client.getTrackers().size() >= 2) {
            discount += 0.05;
        }
        List<String> productTypes = products.stream().map(p -> p.getClass().getSimpleName()).collect(Collectors.toList());;
        if (productTypes.contains("Food") && productTypes.contains("Ticket") && reservations.size() > 0) {
            discount += 0.1;
        }
        int nTickets = (int) products.stream().filter(p -> p.getClass().getSimpleName().equals("Ticket")).count();
        if (reservations.size() >= 2 && nTickets >= 2) {
            discount += 0.05;
        }
        double subTotal = products.stream().mapToDouble(Product::getPrice).sum();
        subTotal += reservations.stream().mapToDouble(Reservation::getPrice).sum();
        return subTotal * discount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
