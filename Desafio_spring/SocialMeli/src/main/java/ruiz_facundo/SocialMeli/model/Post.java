package ruiz_facundo.SocialMeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Post {
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate publishDate;
    private RetailProduct productOnSale;
    private Integer category;
    private Double price;

    public Post () {}

    public Long getId () {
        return this.id;
    }

    public boolean isHasPromo () { return false; }

    public Double getDiscount () { return 0.0; }
}
