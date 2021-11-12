package SocialMeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ProductDTO {
    int product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
}
