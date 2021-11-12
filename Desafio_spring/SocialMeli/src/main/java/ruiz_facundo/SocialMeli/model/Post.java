package ruiz_facundo.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Post {
    private Long id;
    private LocalDate publishDate;
    private PostProduct productOnSale;
    private Integer category;
    private Double price;

    public Post () {}

    public Long getId() {
        return this.id;
    }

    public boolean hasPromo() { return false; }
}
