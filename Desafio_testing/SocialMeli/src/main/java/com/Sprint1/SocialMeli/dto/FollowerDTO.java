package com.Sprint1.SocialMeli.dto;

import com.Sprint1.SocialMeli.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class FollowerDTO  {
    public int user_id;
    public String user_name;



    @Override
    public String toString() {
        return "{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                '}';
    }


}
