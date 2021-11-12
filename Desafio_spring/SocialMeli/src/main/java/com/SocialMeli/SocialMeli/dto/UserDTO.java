package com.SocialMeli.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Integer user_id;
    private String user_name;
    /*List<UserDTO> followers;
    List<UserDTO> followed;*/
    /*@JsonInclude(JsonInclude.Include.NON_NULL)
    List<Integer> followers;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Integer> followed;*/

    @Override
    public String toString() {
        return "UserDTO{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
