package meli.bootcamp.socialmeli.dto;

import meli.bootcamp.socialmeli.model.Product;

public class ProductsPostDTO {
    private int user_id;
    private int id_post;
    private String date;
    public ProductsDTO detail;
    public String category;
    public double price;

    public ProductsPostDTO(int user_id, int id_post, String date, ProductsDTO detail, String category, double price) {
        this.user_id = user_id;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public ProductsPostDTO() {
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

    @Override
    public String toString() {
        return "ProductsPostDTO{" +
                "user_id=" + user_id +
                ", id_post=" + id_post +
                ", date='" + date + '\'' +
                ", detail=" + detail.toString() +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
