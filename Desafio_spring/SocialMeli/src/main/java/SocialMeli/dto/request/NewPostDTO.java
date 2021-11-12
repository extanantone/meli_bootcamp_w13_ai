package SocialMeli.dto.request;

import SocialMeli.dto.response.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Getter
@ToString
public class NewPostDTO {
    int user_id;
    int id_post;

    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;

    ProductDTO detail;
    int category;
    double price;
}
