package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.dto.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{

    private final List<BuyersDTO> buyersDTOList = new ArrayList<>();
    private final List<SellersDTO> sellersDTOList = new ArrayList<>();
    private final List<PostUserDTO> postDTOList = new ArrayList<>();
    private final List<PostPromoUserDTO> postPromoDTOList = new ArrayList<>();

    @Override
    public UserDTO createBuyers(UserDTO user) {
        BuyersDTO buyersDTO = new BuyersDTO();

        if(user.getUser_id() == null){

            buyersDTO.setUser_id(buyersDTOList.size()+1);
            buyersDTO.setUser_name(user.getUser_name());
            buyersDTOList.add(buyersDTO);
        }

        return buyersDTO;
    }

    @Override
    public UserDTO createSellers(UserDTO user) {
        SellersDTO sellersDTO = new SellersDTO();

        if(user.getUser_id() == null){
            sellersDTO.setUser_id(sellersDTOList.size()+1);
            sellersDTO.setUser_name(user.getUser_name());
            sellersDTOList.add(sellersDTO);
        }

        return sellersDTO;
    }

    @Override
    public BuyersDTO findBuyerByUserId(Integer user_id) {
        BuyersDTO buyersDTO = null;
        try{
            buyersDTO = buyersDTOList.get(user_id-1);
            //System.out.println(userDTO.toString());
            throw new IndexOutOfBoundsException("El usuario no existe con id -> " + user_id );

        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }


        return buyersDTO;
    }

    @Override
    public SellersDTO findSellerByUserId(Integer user_id) {
        SellersDTO sellersDTO = null;
        try{
            sellersDTO = sellersDTOList.get(user_id-1);
            //System.out.println(userDTO.toString());
            throw new IndexOutOfBoundsException("El usuario no existe con id -> " + user_id );

        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }


        return sellersDTO;
    }



    @Override
    public Boolean follow(Integer user_id, Integer user_id_to_follow) {
        BuyersDTO buyerUser = findBuyerByUserId(user_id);
        SellersDTO sellerUser = findSellerByUserId(user_id_to_follow);
        Boolean band = false;

        if( buyerUser != null && sellerUser != null ){
            //Al buyer se le agrega el usuario a seguir(seller)
            //List<UserDTO> followedList = current_user.getFollowed();
            List<UserDTO> followedList = buyerUser.getFollowed();
            if( followedList == null ){
                followedList = new ArrayList<UserDTO>();
            }

            UserDTO userDTO = followedList.stream()
                    .filter( user -> sellerUser.getUser_id() == user.getUser_id() )
                    .findAny()
                    .orElse(null);

            if( userDTO == null ){
                userDTO = new UserDTO(sellerUser.getUser_id(), sellerUser.getUser_name());
                //System.out.println(sellerUser);
                //System.out.println(userDTO);
                followedList.add(userDTO);
                buyerUser.setFollowed(followedList);
                band = true;
            }
            /*
            BuyersDTO followedList = new BuyersDTO();
            followedList.setUser_id(buyerUser.getUser_id());
            followedList.setUser_name(buyerUser.getUser_name());
            List<UserDTO> followedUsersList = buyerUser.getFollowed();*/




            //Al vendedor se le agrega al usuario comprador
            //List<UserDTO> followersList = follow_user.getFollowers();
            List<UserDTO> followersList = sellerUser.getFollowers();
            if( followersList == null ){
                followersList = new ArrayList<>();
            }

            UserDTO userDTO2 = followersList.stream()
                    .filter( user -> buyerUser.getUser_id() == user.getUser_id() )
                    .findAny()
                    .orElse(null);
            if( userDTO2 == null && band ){
                userDTO2 = new UserDTO(buyerUser.getUser_id(), buyerUser.getUser_name());
                //System.out.println(buyerUser);

                followersList.add(userDTO2);
                sellerUser.setFollowers(followersList);
            }else{
                band = false;
            }


        }

        return band;
    }

    @Override
    public FollowersCountDTO followersCount(Integer user_id) {
        SellersDTO sellersDTO = findSellerByUserId(user_id);
        FollowersCountDTO user = new FollowersCountDTO();
        Integer count = 0;

        if( sellersDTO != null ){
            user.setUser_id(sellersDTO.getUser_id());
            user.setUser_name(sellersDTO.getUser_name());
            if( sellersDTO.getFollowers() != null ){
                count = sellersDTO.getFollowers().size();
            }
            //System.out.println(count);
            user.setFollowers_count(count);
        }

        return user;
    }

    @Override
    public SellersDTO followersList(Integer user_id) {
        SellersDTO sellersDTO = findSellerByUserId(user_id);

        if( sellersDTO != null ){
            /*user.setUser_id(userDTO.getUser_id());
            user.setUser_name(userDTO.getUser_name());*/
            /*if( userDTO.getFollowers() != null ){
                List<UserDTO> followersList = new ArrayList<>();

                for( Integer i : userDTO.getFollowers() ){
                    System.out.println(i);
                    UserDTO follower = findUserByUserId(i);
                    followersList.add(follower);
                }
                user.setFollowersList(followersList);
            }*/
            System.out.println(sellersDTO.getFollowers());

        }

        return sellersDTO;
    }

    @Override
    public BuyersDTO followedList(Integer user_id) {
        return findBuyerByUserId(user_id);
    }

    @Override
    public Boolean createPost(PostUserDTO post) {
        Boolean band = false;

        SellersDTO sellersDTO = findSellerByUserId(post.getUser_id());

        if( sellersDTO != null ){
            postDTOList.add(post);
            band = true;
        }

        return band;
    }

    @Override
    public PostListDTO postList(Integer user_id, String order) {
        SellersDTO sellersDTO = findSellerByUserId(user_id);
        PostListDTO postListDTO = new PostListDTO();

        if( sellersDTO != null ){

            postListDTO.setUser_id(user_id);

            List<PostUserDTO> postsUser = new ArrayList<>();
            List<PostDTO> posts = new ArrayList<>();

            postsUser = postDTOList.stream()
                    .filter( post -> post.getUser_id() == user_id )
                    .collect(Collectors.toList());

            for( PostUserDTO postUser : postsUser ){
                posts.add(
                        new PostDTO(
                                postUser.getId_post(),
                                postUser.getDate(),
                                postUser.getCategory(),
                                postUser.getPrice(),
                                postUser.getDetail()
                        )
                );
            }

            posts.sort(new Comparator<PostDTO>() {
                @Override
                public int compare(PostDTO o1, PostDTO o2) {
                    return o2.getDate().compareTo(o1.getDate());
                }
            });

            if ( order.equals("date_asc") ){
                posts.sort(new Comparator<PostDTO>() {
                    @Override
                    public int compare(PostDTO o1, PostDTO o2) {
                        return o1.getDate().compareTo(o2.getDate());
                    }
                });
            }

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy");

            LocalDate fifteenDaysAgo = LocalDate.now(ZoneId.of("America/Bogota")).minusDays(15);
            System.out.println("dd/MM/yyy" + dtf.format(fifteenDaysAgo));

            posts = posts.stream()
                    .filter( post -> post.getDate().isAfter( fifteenDaysAgo ))
                    .collect(Collectors.toList());

            postListDTO.setPosts(posts);
        }

        return postListDTO;
    }

    @Override
    public Boolean unfollow(Integer user_id, Integer user_id_to_unfollow) {
        BuyersDTO buyerUser = findBuyerByUserId(user_id);
        SellersDTO sellerUser = findSellerByUserId(user_id_to_unfollow);
        Boolean band = false;

        if( buyerUser != null && sellerUser != null ){
            //Al buyer se le elimina el usuario a seguir(seller)
            List<UserDTO> followedList = buyerUser.getFollowed();
            if( followedList != null ){

                UserDTO userDTO = followedList.stream()
                        .filter( user -> sellerUser.getUser_id() == user.getUser_id() )
                        .findAny()
                        .orElse(null);

                if( userDTO != null ) {
                    //userDTO = new UserDTO(sellerUser.getUser_id(), sellerUser.getUser_name());
                    followedList.remove(userDTO);

                    /*Iterator itr = followedList.iterator();

                    while (itr.hasNext()){

                    }*/

                    buyerUser.setFollowed(followedList);
                    band = true;
                }
            }

            //Al vendedor se le elimina al usuario comprador
            List<UserDTO> followersList = sellerUser.getFollowers();
            if( followersList != null && band ) {

                UserDTO userDTO2 = followersList.stream()
                        .filter(user -> buyerUser.getUser_id() == user.getUser_id())
                        .findAny()
                        .orElse(null);

                if (userDTO2 != null) {
                    //userDTO2 = new UserDTO(buyerUser.getUser_id(), buyerUser.getUser_name());

                    followersList.remove(userDTO2);
                    sellerUser.setFollowers(followersList);
                } else {
                    band = false;
                }
            }

        }

        System.out.println(sellerUser.toString());

        return band;
    }

    @Override
    public BuyersDTO followedListSorted(Integer userId, String order) {
        BuyersDTO buyersDTO = findBuyerByUserId(userId);
        System.out.println(order);

        if ( order.equals("name_asc") ){
            buyersDTO.getFollowed().sort(new Comparator<UserDTO>() {
                @Override
                public int compare(UserDTO o1, UserDTO o2) {
                    return o1.getUser_name().compareToIgnoreCase(o2.getUser_name());
                }
            });
        }else if ( order.equals("name_desc") ){
            buyersDTO.getFollowed().sort(new Comparator<UserDTO>() {
                @Override
                public int compare(UserDTO o1, UserDTO o2) {
                    return o1.getUser_name().compareToIgnoreCase(o2.getUser_name());
                }
            }.reversed());
        }


        return buyersDTO;
    }

    @Override
    public SellersDTO followersListSorted(Integer userId, String order) {
        SellersDTO sellersDTO = findSellerByUserId(userId);
        System.out.println(order);

        if ( order.equals("name_asc") ){
            sellersDTO.getFollowers().sort(new Comparator<UserDTO>() {
                @Override
                public int compare(UserDTO o1, UserDTO o2) {
                    return o1.getUser_name().compareToIgnoreCase(o2.getUser_name());
                }
            });
        }else if ( order.equals("name_desc") ){
            sellersDTO.getFollowers().sort(new Comparator<UserDTO>() {
                @Override
                public int compare(UserDTO o1, UserDTO o2) {
                    return o1.getUser_name().compareToIgnoreCase(o2.getUser_name());
                }
            }.reversed());
        }


        return sellersDTO;
    }

    @Override
    public PostListDTO productsListSorted(Integer user_id, String order) {
        SellersDTO sellersDTO = findSellerByUserId(user_id);
        PostListDTO postListDTO = new PostListDTO();

        if( sellersDTO != null ){

            postListDTO.setUser_id(user_id);

            List<PostUserDTO> postsUser = new ArrayList<>();
            List<PostDTO> posts = new ArrayList<>();

            postsUser = postDTOList.stream()
                    .filter( post -> post.getUser_id() == user_id )
                    .collect(Collectors.toList());

            for( PostUserDTO postUser : postsUser ){
                posts.add(
                        new PostDTO(
                                postUser.getId_post(),
                                postUser.getDate(),
                                postUser.getCategory(),
                                postUser.getPrice(),
                                postUser.getDetail()
                        )
                );
            }

            posts.sort(new Comparator<PostDTO>() {
                @Override
                public int compare(PostDTO o1, PostDTO o2) {
                    return o2.getDate().compareTo(o1.getDate());
                }
            });

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy");

            LocalDate fifteenDaysAgo = LocalDate.now(ZoneId.of("America/Bogota")).minusDays(15);
            System.out.println("dd/MM/yyy" + dtf.format(fifteenDaysAgo));

            posts = posts.stream()
                    .filter( post -> post.getDate().isAfter( fifteenDaysAgo ))
                    .collect(Collectors.toList());

            postListDTO.setPosts(posts);
        }

        return postListDTO;
    }

    // BONUS
    @Override
    public Boolean createPostPromo(PostPromoUserDTO post) {
        Boolean band = false;

        SellersDTO sellersDTO = findSellerByUserId(post.getUser_id());

        if( sellersDTO != null ){
            postPromoDTOList.add(post);
            band = true;
        }

        return band;
    }
}
