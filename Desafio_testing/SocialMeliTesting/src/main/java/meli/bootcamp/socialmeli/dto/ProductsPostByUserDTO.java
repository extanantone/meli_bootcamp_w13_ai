package meli.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductsPostByUserDTO {
    private int idPost;
    private String date;
    public ProductsDTO detail;
    public String category;
    public double price;

    public ProductsPostByUserDTO(int idPost, String date, ProductsDTO detail, String category, double price) {
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public ProductsPostByUserDTO() {
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
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
                ", id_post=" + idPost +
                ", date='" + date + '\'' +
                ", detail=" + detail.toString() +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
