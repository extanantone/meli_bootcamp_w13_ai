package com.mercadolibre.socialmeli.repository;
import com.mercadolibre.socialmeli.enumerator.OrderEnumerator;
import com.mercadolibre.socialmeli.model.*;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SocialRepositoryImpl implements ISocialRepository{

    public SocialRepositoryImpl() {
        usuariosDefault();
    }
    final HashMap<Integer,User> users = new HashMap<>();
    final HashMap<Integer, List<User>> followers = new HashMap<>();
    final HashMap<Integer,List<User>> followed = new HashMap<>();
    final HashMap<Integer,List<Publication>> publications  = new HashMap<>();
    User user;
    List<User> followersList;

    @Override
    public Follow followToUser(int idUser, int idUserToFollow) {
        if(users.isEmpty()) usuariosDefault();
        Follow follow = new Follow();
        User userFollowed = findUserById(idUserToFollow);
        User userFollower = findUserById(idUser);
        //Lista seguidores Quien me sigue
        addUserFollower(idUser,idUserToFollow);
        //Lista de seguidos A quien sigo
        addUserFollowed(idUser,idUserToFollow);

        follow.setUserId(userFollower.getId());
        follow.setIdUserToFollow(userFollowed.getId());
        return follow;
    }

    public void addUserFollower(int idUser, int idUserToFollow){ //Agrego seguidor
        addUserFollow(idUserToFollow, idUser, followers);
    }

    public void addUserFollowed(int idUser, int idUserToFollow){ //Agrego seguido
        addUserFollow(idUser, idUserToFollow, followed);
    }

    private void addUserFollow(int idUser, int idUserToFollow, HashMap<Integer, List<User>> follow) {
        User userFollowed = findUserById(idUserToFollow);
        if(follow.containsKey(idUser)){
            if(!follow.get(idUser).contains(userFollowed)) follow.get(idUser).add(userFollowed);
        }
        else{
            followersList = new ArrayList<>();
            followersList.add(userFollowed);
            follow.put(idUser, followersList);
        }
    }

    @Override
    public User findUserById(int idUser) {
        return users.values().stream().filter(u->u.getId()==idUser).findFirst().orElse(null);
    }

    @Override
    public Followers allFollowers(int userIdFollow) {
        User user = new User();
        List<User>usersFollowers = new ArrayList<>();
        if(users.containsKey(userIdFollow)) user = findUserById(userIdFollow);
        if(followers.containsKey(userIdFollow)) usersFollowers = followers.get(userIdFollow);
        return new Followers(user.getId(), user.getName(), usersFollowers);
    }

    @Override // A quien sigo
    public Followers allFollowed(int idUser) {
        Followers followers = new Followers();
        User user;
        if(users.containsKey(idUser)){
            user = findUserById(idUser);
            followers.setId(user.getId());
            followers.setName(user.getName());
            try{
                List<User>users = followed.get(idUser);
                followers.setUsers(users);
            } catch (NullPointerException e){
                return null;
            }
        }
        return followers;
    }

    @Override
    public Boolean addPublication(Publication publication) {
        if(!users.containsKey(publication.getUserId())) return false;
        if(publications.containsKey(publication.getUserId())) publications.get(publication.getUserId()).add(publication);
        else{
            List<Publication>publicationsList = new ArrayList<>();
            publicationsList.add(publication);
            publications.put(publication.getUserId(),publicationsList);
        }
        return true;
    }


    //Cuantos me siguen
    @Override
    public Long countFollowers(int userIdFollow) {
        if (!followers.containsKey(userIdFollow)) return 0L;
        return (long) followers.get(userIdFollow).size();
    }

    @Override
    public PublicationsFollowed latestPublications(int userId) {
        PublicationsFollowed publicationsFollowed = new PublicationsFollowed();
        List<Publication> publicationsSellers = new ArrayList<>();
        publicationsFollowed.setUserId(userId);
        //TODO lanza nullPointer si no sigue a nadie
        for(User u : followed.get(userId)){ //Followed contiene la lista de seguidores
            if (publications.containsKey(u.getId())){ //Si se encuentra el id en publicaciones es vendedor
                List<Publication> publication = publications.get(u.getId())
                        .stream().filter(p -> p.getDate()
                                .isAfter(LocalDate.now().minusDays(15)))
                        .collect(Collectors.toList());
                publicationsSellers.addAll(publication);
            }
        }
        publicationsSellers.sort(Comparator.comparing(Publication ::getDate));
        publicationsFollowed.setPosts(publicationsSellers);
        return publicationsFollowed;
    }

    @Override
    public Boolean unFollowUser(int userId, int userIdUnfollow) {
        //TODO no deberia lanzar acá una excepcion,
        // si los usuarios no estan en la lista lanzarlo en el service
        try {
            followed.get(userId)
                    .removeIf(user -> user.getId()==userIdUnfollow);
            followers.get(userIdUnfollow)
                    .removeIf(user -> user.getId()==userId);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Followers orderingUsersFollowers(int userId, String order) {
        return getFollowers(userId, order, followers);
    }

    private Followers getFollowers(int userId, String order, HashMap<Integer, List<User>> follow) {
        user = findUserById(userId);
        if (order.toUpperCase().equals(OrderEnumerator.NAME_DESC.toString())) follow.get(user.getId()).sort(Comparator.comparing(User::getName).reversed());
        else follow.get(userId).sort(Comparator.comparing(User::getName));
        return new Followers(user.getId(),user.getName(), follow.get(userId));
    }

    @Override
    public Followers orderingUsersFolloweds(int userId, String order) {
        return getFollowers(userId, order, followed);
    }

    @Override
    public PublicationsFollowed sortPublicationsSellers(int userId, String order) {
        PublicationsFollowed publicationsFollowed = new PublicationsFollowed();
        List<Publication> publicationsSellers = new ArrayList<>();
        publicationsFollowed.setUserId(userId);
        for(User u : followed.get(userId)){
            if (publications.containsKey(u.getId())){
                List<Publication> publication = new ArrayList<>(publications.get(u.getId()));
                publicationsSellers.addAll(publication);
            }
        }
        publicationsFollowed.setPosts(publicationsSellers);
        if(order.toUpperCase().equals(OrderEnumerator.DATE_ASC.toString())) publicationsSellers.sort(Comparator.comparing(Publication ::getDate));
        else publicationsSellers.sort(Comparator.comparing(Publication ::getDate).reversed());
        return publicationsFollowed;
    }

    public void usuariosDefault(){  //TODO Deberia leerlos y cargarlos de un json
        users.put(1,new User(1,"Maggy"));
        users.put(2,new User(2,"Fede"));
        users.put(3,new User(3,"Otro"));
        users.put(4,new User(4,"Analia"));
    }

    /*
    public void save(User user) {
        users.put(user.getId(),user);
    }
    */

}
