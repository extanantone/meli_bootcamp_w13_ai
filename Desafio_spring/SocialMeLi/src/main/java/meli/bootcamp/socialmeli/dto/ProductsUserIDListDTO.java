package meli.bootcamp.socialmeli.dto;

import java.util.List;

public class ProductsUserIDListDTO {
    private int user_id;
    private List<ProductsPostByUserDTO> post;

    public ProductsUserIDListDTO(int user_id, List<ProductsPostByUserDTO> post) {
        this.user_id = user_id;
        this.post = post;
    }

    public ProductsUserIDListDTO() {}

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<ProductsPostByUserDTO> getPost() {
        return post;
    }

    public void setPost(List<ProductsPostByUserDTO> post) {
        this.post = post;
    }
}
