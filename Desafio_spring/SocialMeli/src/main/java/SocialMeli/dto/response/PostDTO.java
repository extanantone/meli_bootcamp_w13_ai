package SocialMeli.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NonNull
public class PostDTO {
    int id_post;

    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;

    ProductDTO detail;
    int category;
    double price;

}
