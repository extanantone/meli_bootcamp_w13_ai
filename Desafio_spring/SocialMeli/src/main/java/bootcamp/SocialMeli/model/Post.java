package bootcamp.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Post {
    String postId;
    public LocalDate date;
    int itemId;
    String itemName;
    String type;
    int categoria;
    int precio;
    //   boolean b;
    //  int i;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return postId == post.postId;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}








