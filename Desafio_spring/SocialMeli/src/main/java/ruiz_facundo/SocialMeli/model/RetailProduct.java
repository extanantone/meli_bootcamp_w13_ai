package ruiz_facundo.SocialMeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RetailProduct {
    private Long id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public RetailProduct () {}
}
