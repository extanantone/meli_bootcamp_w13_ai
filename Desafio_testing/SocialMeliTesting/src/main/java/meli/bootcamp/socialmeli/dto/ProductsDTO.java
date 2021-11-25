package meli.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductsDTO {

    @Positive(message = "El id debe ser mayor a cero")
    @NotBlank(message = "La id no puede estar vacía")
    private int productId;

    @NotBlank(message = "El campo no puede estar vacío")
    @Size(max= 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "/[$%&|<>#]/", message = "El campo no puede poseer caracteres especiales")
    private String productName;

    @NotBlank(message = "El campo no puede estar vacío")
    @Size(max= 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "/[$%&|<>#]/", message = "El campo no puede poseer caracteres especiales")
    private String type;

    @NotBlank(message = "El campo no puede estar vacío")
    @Size(max= 25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = "/[$%&|<>#]/", message = "El campo no puede poseer caracteres especiales")
    private String brand;

    @NotBlank(message = "El campo no puede estar vacío")
    @Size(max= 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "/[$%&|<>#]/", message = "El campo no puede poseer caracteres especiales")
    private String color;

    @Size(max= 80, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "/[$%&|<>#]/", message = "El campo no puede poseer caracteres especiales")
    private String notes;

    public ProductsDTO(int productId, String productName, String type, String brand, String color, String notes) {
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public ProductsDTO(int productId, String productName, String type, String brand, String color) {
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = "No note";
    }

    public ProductsDTO() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
