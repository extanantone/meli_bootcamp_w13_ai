package bootcamp.SocialMeli.repository;


import bootcamp.SocialMeli.model.User;

public interface IRepository {
    User getUserById(int id);
}
