package meli.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductsPostDTO {

    @Positive(message = "El id debe ser mayor a cero")
    @Range(min = 1, message = "La id no puede estar vacía")
    private int userId;

    @Positive(message = "El id debe ser mayor a cero")
    @Range(min = 1, message = "La id no puede estar vacía")
    private int idPost;

    @NotBlank(message = "La fecha no puede estar vacía")
    private String date;

    @NotEmpty(message = "Debe ingresar un producto a la publicación")
    public ProductsDTO detail;

    @NotBlank(message = "La id no puede estar vacía")
    public String category;

    @Positive(message = "El id debe ser mayor a cero")
    @NotBlank(message = "El campo no puede estar vacio")
    @Range(max = 10000000, message = "La id no puede estar vacía")
    public double price;

    public ProductsPostDTO(int userId, int idPost, String date, ProductsDTO detail, String category, double price) {
        this.userId = userId;
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public ProductsPostDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
                "user_id=" + userId +
                ", id_post=" + idPost +
                ", date='" + date + '\'' +
                ", detail=" + detail.toString() +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
