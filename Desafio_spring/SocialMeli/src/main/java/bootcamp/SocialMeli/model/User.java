package bootcamp.SocialMeli.model;

import bootcamp.SocialMeli.exception.InvalidPostException;
import bootcamp.SocialMeli.exception.InvalidUserException;
import bootcamp.SocialMeli.exception.NotFoundUserException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class User {

    public static int cont = 0;

    public int id;
    public String name;
    public String lastname;
    public List<User> followers;
    public boolean seller;
    private List<Post> posts;


    public User(){
        id=++cont;
        followers = new ArrayList();
        posts = new ArrayList();
    }

    public User(String name, String lastname, boolean seller){
        this();
        this.name = name;
        this.lastname = lastname;
        this.seller = seller;
    }

    public void addFollower(User follower){
        if(!seller)
            throw new InvalidUserException("No se puede seguir al usuario");
        else if(followers.contains(follower))
            throw new InvalidUserException("Estas siguiendo a este usuario");
        followers.add(follower);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isFollower(User user){
        return  followers.contains(user);
    }

    public void addPost(Post post){
        //System.out.println(post.getId());
        if (!seller)
            throw new InvalidUserException("Este usuario no es vendedor");
        if(posts.contains(post))
            throw new InvalidPostException("Ya existe una misma publicación para este usuariio");
        posts.add(post);
    }
}
