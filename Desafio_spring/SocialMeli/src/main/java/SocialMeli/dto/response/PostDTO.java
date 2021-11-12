package SocialMeli.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PostDTO {
    int user_id;
    int id_post;

    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;

    ProductDTO detail;
    int category;
    double price;
}
