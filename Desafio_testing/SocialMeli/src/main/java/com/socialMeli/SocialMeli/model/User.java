package com.socialMeli.SocialMeli.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class User {

    private Integer id;

    @Valid
    @NotBlank(message = "el id no puede estar vacio")
    @Pattern(regexp="[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "No se aceptan caracteres especiales")
    @Size(max = 15, message = "La longitud del username no puede superar los 15 caracteres.")
    private String username;

    private List<Integer> following = new ArrayList<>();
    private List<Integer> followers = new ArrayList<>();

    public User(Integer id, String username) {
        this.id=id;
        this.username=username;
    }

    public Integer getId() {
        return id;
    }




    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getFollowing() {
        return following;
    }

    public void setFollowing(List<Integer> following) {
        this.following = following;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }
}
