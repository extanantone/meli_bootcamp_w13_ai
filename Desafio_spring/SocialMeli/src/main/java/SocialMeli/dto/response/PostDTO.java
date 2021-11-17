package SocialMeli.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO {
    int idPost;

    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;

    ProductDTO detail;
    int category;
    double price;

    //BONUS
    Boolean hasPromo;
    Double discount;
}
