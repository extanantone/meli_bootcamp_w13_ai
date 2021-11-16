package meli.bootcamp.socialmeli.dto;

public class PromoPostCountDTO {
    private int user_id;
    private String user_name;
    private int promo_post_count;

    public PromoPostCountDTO(int user_id, String user_name, int promo_post_count) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.promo_post_count = promo_post_count;
    }

    public PromoPostCountDTO() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getPromo_post_count() {
        return promo_post_count;
    }

    public void setPromo_post_count(int promo_post_count) {
        this.promo_post_count = promo_post_count;
    }
}
