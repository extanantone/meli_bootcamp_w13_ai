package ruiz_facundo.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostProduct {
    private Long id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public PostProduct () {}
}
