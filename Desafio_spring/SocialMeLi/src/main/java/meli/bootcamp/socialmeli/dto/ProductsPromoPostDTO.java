package meli.bootcamp.socialmeli.dto;

public class ProductsPromoPostDTO {
    private int user_id;
    private int id_post;
    private String date;
    private ProductsDTO detail;
    private String category;
    private double price;
    private boolean has_promo;
    private double discount;

    public ProductsPromoPostDTO(int user_id, int id_post, String date, ProductsDTO detail, String category, double price, boolean has_promo, double discount) {
        this.user_id = user_id;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public ProductsPromoPostDTO() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ProductsDTO getDetail() {
        return detail;
    }

    public void setDetail(ProductsDTO detail) {
        this.detail = detail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHas_promo() {
        return has_promo;
    }

    public void setHas_promo(boolean has_promo) {
        this.has_promo = has_promo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "ProductsPromoPostDTO{" +
                "user_id=" + user_id +
                ", id_post=" + id_post +
                ", date='" + date + '\'' +
                ", detail=" + detail.toString() +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", has_promo=" + has_promo +
                ", discount=" + discount +
                '}';
    }
}
