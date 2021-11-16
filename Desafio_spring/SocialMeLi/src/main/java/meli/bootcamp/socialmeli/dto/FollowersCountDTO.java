package meli.bootcamp.socialmeli.dto;

public class FollowersCountDTO {
    private int user_id;
    private String user_name;
    private int followers_count;

    public FollowersCountDTO(int user_id, String user_name, int followers_count) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.followers_count = followers_count;
    }

    public FollowersCountDTO() {
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

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }
}
