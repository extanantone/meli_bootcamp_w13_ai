package com.socialmeli.repository;

import com.socialmeli.model.Post;
import com.socialmeli.model.User;
import org.apache.el.lang.FunctionMapperImpl;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{

    private List<User> users;

    public UserRepository(){
        users = new ArrayList<>();
        users.add(new User("Juan","juan@mail.com",false));
        users.add(new User("David","david@mail.com",false));
        users.add(new User("Diego","diego@mail.com",true));
        users.add(new User("Pablo","pablo@mail.com",true));
    }

    @Override
    public User getUserById(int id) {
        return users.stream().filter(i->i.getId()==id)
                .findFirst().orElse(null);
    }

    @Override
    public List<User> followedUser(User user) {
        return users.stream().filter(u->u.isFollower(user)).collect(Collectors.toList());
    }

    @Override
    public List<Post> getPostLastTwoWeeksOfFollowed(int idUser) {
        return users.stream().filter(u->u.isFollower(getUserById(idUser))).flatMap(u->u.getPosts().stream())
                    .filter(l->l.getDate().isAfter(LocalDate.now().minusWeeks(2))).collect(Collectors.toList());
    }

    @Override
    public List<Post> getPromoPostByUserId(int userId) {
        return users.stream().flatMap(u->u.getPosts().stream()).filter(p->p.isHasDiscount())
                .collect(Collectors.toList());
    }
}
