package com.SocialMeli.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostUserDTO extends PostDTO{
    @NotNull( message = "La id no puede estar vacía.")
    @Positive( message = "El id debe ser mayor a cero")
    private Integer user_id;

    public PostUserDTO(Integer user_id, PostDTO postDTO) {
        super(postDTO.getId_post(), postDTO.getDate(), postDTO.getCategory(), postDTO.getPrice(), postDTO.getDetail());
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "PostUserDTO{" +
                "user_id=" + user_id +
                '}';
    }
}
