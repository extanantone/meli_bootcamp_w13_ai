package SocialMeli.dto.request;

import SocialMeli.dto.response.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
public class NewPostDTO {

    @Positive(message = "Debe ser un entero positivo")
    int userId;

    @Positive(message = "Debe ser un entero positivo")
    int idPost;

    @NotNull(message = "No puede estar vacía")
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;

    @Valid
    ProductDTO detail;

    @Positive(message = "Debe ser un entero positivo")
    int category;

    @Positive(message = "Debe ser un entero positivo")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    double price;

    // Bonus promo
    boolean hasPromo;
    double discount;
}
