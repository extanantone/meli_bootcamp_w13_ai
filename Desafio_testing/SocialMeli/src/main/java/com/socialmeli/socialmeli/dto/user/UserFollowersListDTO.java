package com.socialmeli.socialmeli.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.socialmeli.socialmeli.dto.post.PostDTO;
import com.socialmeli.socialmeli.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserFollowersListDTO {
    @Min(value=0, message = "El id de usuario debe ser mayor a cero")
    int user_id;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 10, message = "La longitud no puede superar los 15 caracteres.")
    String user_name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<UserDTO> followers;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<UserDTO> followed;

    public UserFollowersListDTO(int user_id, String user_name,boolean userFollowers) {
        this.user_id = user_id;
        this.user_name = user_name;
        if (userFollowers) {
            followers = new ArrayList<UserDTO>();
            followed = null;
        } else{
            followed = new ArrayList<UserDTO>();
            followers=null;
        }


    }

    public void addFollowers(UserDTO userDTO,boolean useFollowers){
        if (useFollowers){
            followers.add(userDTO);
            followed = null;
        } else {
            followed.add(userDTO);
            followers = null;
        }

    }


}
