package meli.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductsUserIDListDTO {
    private int userId;
    private List<ProductsPostByUserDTO> post;

    public ProductsUserIDListDTO(int userId, List<ProductsPostByUserDTO> post) {
        this.userId = userId;
        this.post = post;
    }

    public ProductsUserIDListDTO() {}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<ProductsPostByUserDTO> getPost() {
        return post;
    }

    public void setPost(List<ProductsPostByUserDTO> post) {
        this.post = post;
    }
}
