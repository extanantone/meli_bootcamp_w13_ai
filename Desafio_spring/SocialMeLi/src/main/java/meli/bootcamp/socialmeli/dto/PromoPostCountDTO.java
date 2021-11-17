package meli.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostCountDTO {
    private int userId;
    private String userName;
    private int promoPostCount;

    public PromoPostCountDTO(int userId, String userName, int promoPostCount) {
        this.userId = userId;
        this.userName = userName;
        this.promoPostCount = promoPostCount;
    }

    public PromoPostCountDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPromoPostCount() {
        return promoPostCount;
    }

    public void setPromoPostCount(int promoPostCount) {
        this.promoPostCount = promoPostCount;
    }
}
