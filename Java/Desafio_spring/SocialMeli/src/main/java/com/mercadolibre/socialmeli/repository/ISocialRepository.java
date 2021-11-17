package com.mercadolibre.socialmeli.repository;

import com.mercadolibre.socialmeli.model.*;

public interface ISocialRepository {
     Follow followToUser(int idUser, int idUserToFollow);
     User findUserById(int idUser);
     Followers allFollowers(int userIdFollow);
     Followers allFollowed(int idUser);
     Boolean addPublication(Publication publication);
     Long countFollowers(int userIdFollow);
     PublicationsFollowed latestPublications(int userId);
     Boolean unFollowUser(int userId, int userIdUnfollow);
     Followers orderingUsersFollowers(int userId, String order);
     Followers orderingUsersFolloweds(int userId, String order);
     PublicationsFollowed sortPublicationsSellers(int userId, String order);
}
