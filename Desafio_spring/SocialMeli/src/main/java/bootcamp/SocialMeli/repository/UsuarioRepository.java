package bootcamp.SocialMeli.repository;

import bootcamp.SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository implements IRepository{

    private List<User> users;

    public UsuarioRepository(){
        users = new ArrayList<>();
        users.add(new User("Jorge", "De Michiel", false));
        users.add(new User("Pablo", "Perez", false));
        users.add(new User("Victoria", "Lopez", true));
        users.add(new User("Caludia", "Suarez", true));
    }

    @Override
    public User getUserById(int id){
        return users.stream()
                .filter(i -> i.getId()==id)
                .findFirst().orElse(null);
    }


}
