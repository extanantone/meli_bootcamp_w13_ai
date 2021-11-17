package com.SprintI.SocialMeli.repositories;

import com.SprintI.SocialMeli.exceptions.UserNotFoundException;
import com.SprintI.SocialMeli.models.Post;
import com.SprintI.SocialMeli.models.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImplements implements UserRepository{
    private List<User> users;

    public UserRepositoryImplements() {
        this.users = new ArrayList<>();
        this.users.add( new User(1,"Ana"));
        this.users.add( new User(2,"Bautista"));
        this.users.add( new User(3,"Carmela"));
        this.users.add( new User(4,"Branko"));
        this.users.add( new User(5,"Barbara"));
        this.users.add( new User(6,"Bolivia"));
    }

    @Override
    public User findById(int id) {
        return this.users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("The user with id: " + id + " don't exist."));
    }

    @Override
    public List<User> getUsers() {
        return this.users;
    }

    /*@Override
    public List<Post> getPostFollowed(int id) {
        User user = this.findById(id);
        System.out.println(user);
        List<User> usersFollowed = this.users.stream().forEach(x -> x.getFollowers().stream().filter(u -> u.getId() == user.getId()));
        System.out.println(usersFollowed);
        List<Post> post = new ArrayList<>();
                usersFollowed.stream().forEach(x -> x.getPost().forEach(u -> post.add(u)));
        System.out.println(post);
        LocalDate now = LocalDate.now();
        LocalDate last14days = now.minusDays(14);
        List<Post> postLas14Days = post.stream().filter(x -> (x.getDate().isAfter(now) && x.getDate().isBefore(last14days))).collect(Collectors.toList());
        System.out.println(postLas14Days);
        return  postLas14Days;
    }*/


}
