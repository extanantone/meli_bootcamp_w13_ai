package bootcamp.SocialMeli.repository;


import bootcamp.SocialMeli.model.Post;
import bootcamp.SocialMeli.model.User;

import java.util.List;

public interface IRepository {
    User getUserById(int id);

    List<User> followedUser(User user);

    List<Post> getLastPostTwoWeekAgo(int userId);
}
