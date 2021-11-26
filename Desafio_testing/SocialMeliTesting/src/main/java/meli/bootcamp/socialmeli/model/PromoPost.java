package meli.bootcamp.socialmeli.model;

import java.time.LocalDate;

public class PromoPost extends Post{
    private boolean hasPromo;
    private double discount;

    public PromoPost(int userId, int postId, LocalDate date, Product detail, String category, double price, boolean hasPromo, double discount) {
        super(userId, postId, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public PromoPost(boolean hasPromo, double discount) {
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public PromoPost() {
    }

    public boolean isHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "PromoPost{" + super.toString() +
                "hasPromo=" + hasPromo +
                ", discount=" + discount +
                '}';
    }
}
