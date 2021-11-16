package ruiz_facundo.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDTO implements Serializable {
    private Long idPost;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private RetailProductDTO detail;
    private Integer category;
    private Double price;

    public PostDTO () {}
}
