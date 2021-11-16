package meli.bootcamp.socialmeli.dto;

public class ProductsPostByUserDTO {
    private int id_post;
    private String date;
    public ProductsDTO detail;
    public String category;
    public double price;

    public ProductsPostByUserDTO(int id_post, String date, ProductsDTO detail, String category, double price) {
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public ProductsPostByUserDTO() {
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

    @Override
    public String toString() {
        return "ProductsPostDTO{" +
                ", id_post=" + id_post +
                ", date='" + date + '\'' +
                ", detail=" + detail.toString() +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
