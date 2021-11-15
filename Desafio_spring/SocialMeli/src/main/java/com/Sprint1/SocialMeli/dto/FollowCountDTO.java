package com.Sprint1.SocialMeli.dto;

public class FollowCountDTO {
    private int user_id;
    private String user_name;
    private int followers_count;

    public FollowCountDTO(int user_id, String user_name, int followers_count) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.followers_count = followers_count;
    }

    @Override
    public String toString() {
        return "FollowCountDTO{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", followers_count=" + followers_count +
                '}';
    }
}
