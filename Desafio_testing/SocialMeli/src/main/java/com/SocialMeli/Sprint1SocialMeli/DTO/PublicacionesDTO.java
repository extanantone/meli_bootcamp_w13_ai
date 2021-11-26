package com.SocialMeli.Sprint1SocialMeli.DTO;

import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicacionesDTO {
    private int user_id;
    private List<Publicacion> posts;

    public PublicacionesDTO(int user_id) {
        this.user_id = user_id;
        posts = new ArrayList<>();
    }

    public void agregarPosts(Publicacion post) {
        this.posts.add(post);
    }
}
