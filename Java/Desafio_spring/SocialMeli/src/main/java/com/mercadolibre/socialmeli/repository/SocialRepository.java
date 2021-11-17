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
public class SocialRepository implements ISocialRepository{

    public SocialRepository() {
        usuariosDefault();
    }

    final HashMap<Integer,User> users = new HashMap<>();
    final HashMap<Integer,List<User>> followers = new HashMap<>();
    final HashMap<Integer,List<User>> followed = new HashMap<>();
    final HashMap<Integer,List<Publication>> publications  = new HashMap<>();
    User user;
    List<User> followersList;

    @Override
    public Follow followToUser(int idUser, int idUserToFollow) {
        Follow follow = new Follow();
        User userFollowed = findUserById(idUserToFollow);
        User userFollower = findUserById(idUser);
        System.out.println("userFollowed: " + userFollowed);
        System.out.println("userFollower: " + userFollower);
        if (userFollower!= null && userFollowed!=null && idUser!=idUserToFollow){
            //Lista seguidores Quien me sigue
            if (followers.containsKey(idUserToFollow)){
                followers.get(idUserToFollow).add(userFollower);
            } else{
                followersList = new ArrayList<>();
                followersList.add(userFollower);
                followers.put(idUserToFollow, followersList);
            }
            //Lista de seguidos A quien sigo
            if(followed.containsKey(idUser)){
                followed.get(idUser).add(userFollowed);
            }
            else{
                followersList = new ArrayList<>();
                followersList.add(userFollowed);
                followed.put(idUser, followersList);
            }
            follow.setIdUserToFollow(idUserToFollow);
            follow.setUserId(idUser);
        }

        return follow;
    }

    @Override
    public User findUserById(int idUser) {
        return users.values().stream().filter(u->u.getId()==idUser).findFirst().orElse(null);
    }

    @Override
    public Followers allFollowers(int userIdFollow) {
        User user = findUserById(userIdFollow);
        List<User>users = followers.get(userIdFollow);
        return new Followers(user.getId(), user.getName(), users);
    }

    @Override // A quien sigo
    public Followers allFollowed(int idUser) {
        User user = findUserById(idUser);
        List<User>users = followed.get(idUser);
        System.out.println(user.toString());
        return new Followers(user.getId(),user.getName(),users);
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

    /*
    private Boolean saveUser(User user){
        if(!users.containsKey(user.getId())){
            users.put(cantUsers++,user);
            return true;
        }
        return false;
    }*/

    //Cuantos me siguen
    @Override
    public Long countFollowers(int userIdFollow) {
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
                                .isAfter(LocalDate.now().minusDays(14)))
                        .collect(Collectors.toList());
                publicationsSellers.addAll(publication);
            }
        }
        publicationsSellers.sort(Comparator.comparing(Publication ::getDate));
        publicationsFollowed.setPublications(publicationsSellers);
        return publicationsFollowed;
    }

    @Override
    public Boolean unFollowUser(int userId, int userIdUnfollow) {
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

    private Followers getFollowers(int userId, String order, HashMap<Integer, List<User>> followeds) {
        user = findUserById(userId);
        if(order.toUpperCase().equals(OrderEnumerator.NAME_DESC.toString())) followeds.get(userId).sort(Comparator.comparing(User ::getName).reversed());
        else followeds.get(userId).sort(Comparator.comparing(User::getName));
        return new Followers(user.getId(),user.getName(), followeds.get(userId));
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
        //TODO lanza nullPointer si no sigue a nadie
        for(User u : followed.get(userId)){
            if (publications.containsKey(u.getId())){
                List<Publication> publication = new ArrayList<>(publications.get(u.getId()));
                publicationsSellers.addAll(publication);
            }
        }
        publicationsFollowed.setPublications(publicationsSellers);
        if(order.toUpperCase().equals(OrderEnumerator.DATE_ASC.toString())) publicationsSellers.sort(Comparator.comparing(Publication ::getDate));
        else publicationsSellers.sort(Comparator.comparing(Publication ::getDate).reversed());
        return publicationsFollowed;
    }

    public void usuariosDefault(){
        users.put(1,new User(1,"Maggy"));
        users.put(2,new User(2,"Fede"));
        users.put(3,new User(3,"Otro"));
        users.put(4,new User(4,"Analia"));
    }
}
