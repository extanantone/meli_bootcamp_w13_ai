package meli.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostDTO {
    private int userId;
    private String useName;
    private List<PromoPostBaseDTO> post;

    public PromoPostDTO(int userId, String useName, List<PromoPostBaseDTO> post) {
        this.userId = userId;
        this.useName = useName;
        this.post = post;
    }

    public PromoPostDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public List<PromoPostBaseDTO> getPost() {
        return post;
    }

    public void setPost(List<PromoPostBaseDTO> post) {
        this.post = post;
    }
}
