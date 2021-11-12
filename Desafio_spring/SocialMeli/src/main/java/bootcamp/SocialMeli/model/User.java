package bootcamp.SocialMeli.model;

import bootcamp.SocialMeli.exception.InvalidUserException;
import bootcamp.SocialMeli.exception.NotFoundUserException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {

    public static int cont = 0;

    public int id;
    public String name;
    public String lastname;
    public List<User> followers;
    public boolean seller;


    public User(){
        id=++cont;
        followers = new ArrayList();
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
}
