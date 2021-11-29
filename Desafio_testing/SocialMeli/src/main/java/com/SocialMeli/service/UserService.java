package com.SocialMeli.service;

import com.SocialMeli.dto.*;
import com.SocialMeli.exceptions.BadRequestException;
import com.SocialMeli.exceptions.NotFoundException;
import com.SocialMeli.model.Post;
import com.SocialMeli.model.PromoPost;
import com.SocialMeli.model.User;
import com.SocialMeli.repository.UserRepositoryI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceI {
    final
    UserRepositoryI repository;

    public UserService(UserRepositoryI repository) {
        this.repository = repository;
    }

    @Override
    public List<UserDTO> getUsersDTO() {
        HashMap<Integer, User> users = repository.getUsers();
        List<UserDTO> res = new ArrayList<>();
        users.forEach((id, user) -> {
            UserDTO userDTO = new UserDTO(id, user.getUserName());
            res.add(userDTO);
        });
        return res;
    }

    private boolean isUserIdValid(int userId) {
        if (userId > 0) {
            HashMap<Integer, User> usersList = repository.getUsers();

            return usersList.containsKey(userId);
        } else return false;
    }

    @Override
    public ResponseEntity<String> followUser(int userId, int userIdToFollow) {
        HashMap<Integer, User> usersList = repository.getUsers();

        if (userId != userIdToFollow && isUserIdValid(userId) && isUserIdValid(userIdToFollow)) {

            List<Integer> followers = usersList.get(userIdToFollow).getFollowers();
            List<Integer> followedUsers = usersList.get(userId).getFollowedUsers();

            if (!followers.contains(userId) && !followedUsers.contains(userIdToFollow)) {
                followers.add(userId);
                followedUsers.add(userIdToFollow);
            } else {
                throw new BadRequestException("User with id " + userId + " already follows user " +
                        "with id " + userIdToFollow);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new BadRequestException("Given users are not valid");
        }
    }

    @Override
    public ResponseEntity<String> unfollowUser(int userId, int userIdToUnfollow) {
        HashMap<Integer, User> usersList = repository.getUsers();

        if (userId != userIdToUnfollow && isUserIdValid(userId) && isUserIdValid(userIdToUnfollow)) {
            List<Integer> followers = usersList.get(userIdToUnfollow).getFollowers();
            List<Integer> followedUsers = usersList.get(userId).getFollowedUsers();

            if (followers.contains(userId) && followedUsers.contains(userIdToUnfollow)) {
                followers.remove(Integer.valueOf(userId));
                followedUsers.remove(Integer.valueOf(userIdToUnfollow));
            } else {
                throw new BadRequestException("User with id " + userId + " didn't follow the user" +
                        " with id " + userIdToUnfollow);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new BadRequestException("Given users are not valid");
        }
    }

    @Override
    public ResponseEntity<FollowersCountDTO> getFollowersCount(Integer userId) {
        HashMap<Integer, User> usersList = repository.getUsers();
        if (isUserIdValid(userId)) {
            User user = usersList.get(userId);
            if (user.getIsSeller()) {
                Integer followersCount = user.getFollowers().size();

                FollowersCountDTO res = new FollowersCountDTO(userId, user.getUserName(),
                        followersCount);
                return new ResponseEntity<>(res, HttpStatus.OK);
            } else {
                throw new BadRequestException("The user is not a seller");
            }
        } else {
            throw new NotFoundException("The user does not exist");
        }
    }

    private List<UserDTO> orderUsersList(String order, List<UserDTO> list) {
        List<UserDTO> res = list.stream().
                sorted(Comparator.comparing(UserDTO::getUserName, String.CASE_INSENSITIVE_ORDER)).
                collect(Collectors.toList());
        if (Objects.isNull(order)) {
            throw new BadRequestException("Order param is required");
        } else if (order.equals("name_desc")) {
            Collections.reverse(res);
        } else if (!order.equals("name_asc")) {
            throw new BadRequestException("Order requested is not valid");
        }
        return res;
    }

    @Override
    public ResponseEntity<FollowersDTO> getSellerFollowersList(Integer userId, String order) {
        HashMap<Integer, User> usersList = repository.getUsers();
        User user = usersList.get(userId);

        if (isUserIdValid(userId)) {
            if (user.getIsSeller()) {
                FollowersDTO res = new FollowersDTO(userId, user.getUserName());
                List<Integer> followers = user.getFollowers();

                for (Integer id : followers) {
                    User follower = usersList.get(id);
                    UserDTO followerDTO = new UserDTO(follower.getId(), follower.getUserName());
                    res.getFollowers().add(followerDTO);
                }

                res.setFollowers(orderUsersList(order, res.getFollowers()));
                return new ResponseEntity<>(res, HttpStatus.OK);

            }
            throw new NotFoundException("The user is not a seller");
        } else {
            throw new NotFoundException("The user does not exist");
        }
    }

    @Override
    public ResponseEntity<FollowedUsersDTO> getFollowedSellersList(Integer userId, String order) {
        HashMap<Integer, User> usersList = repository.getUsers();
        User user = usersList.get(userId);

        if (isUserIdValid(userId)) {
            FollowedUsersDTO res = new FollowedUsersDTO(userId, user.getUserName());
            List<Integer> followedUsers = user.getFollowedUsers();

            for (Integer id : followedUsers) {
                User followedUser = usersList.get(id);
                if (followedUser.getIsSeller()) {
                    UserDTO followerDTO = new UserDTO(followedUser.getId(),
                            followedUser.getUserName());
                    res.getFollowedUsers().add(followerDTO);
                }
            }

            res.setFollowedUsers(orderUsersList(order, res.getFollowedUsers()));
            return new ResponseEntity<>(res, HttpStatus.OK);


        } else {
            throw new NotFoundException("The user does not exist");
        }
    }

    @Override
    public ResponseEntity<String> createPost(PostDTO newPost) {
        HashMap<Integer, User> usersList = repository.getUsers();
        Integer userId = newPost.getUserId();

        if (isUserIdValid(userId)) {
            if (repository.getPosts().containsKey(newPost.getIdPost())) {
                throw new BadRequestException("There's already a post with id_post " + newPost.getIdPost());
            } else {

                User user = usersList.get(userId);
                user.setIsSeller(true);

                user.getPosts().add(newPost.getIdPost());
                repository.addPost(new Post(newPost));

                return new ResponseEntity<>(HttpStatus.OK);
            }
        } else {
            throw new BadRequestException("Given data is not correct");
        }

    }

    private boolean isPostRecent(Post post) {
        int months = Period.between(post.getDate(), LocalDate.now()).getMonths();
        if (months < 1) {
            return Period.between(post.getDate(), LocalDate.now()).getDays() <= 14;
        } else return false;
    }

    private List<User> getFollowedSellers(User user) {
        HashMap<Integer, User> usersList = repository.getUsers();

        List<Integer> userIds = user.getFollowedUsers().stream().
                filter(id -> usersList.get(id).getIsSeller()).collect(Collectors.toList());

        return userIds.stream().map(usersList::get).
                collect(Collectors.toList());
    }

    private List<PostsListDTO> createPostsListResponse(Integer userId, String order) {
        HashMap<Integer, User> usersList = repository.getUsers();
        User user = usersList.get(userId);
        List<User> followedSellers = getFollowedSellers(user);

        HashMap<Integer, Post> postsList = repository.getPosts();

        List<PostsListDTO> res = new ArrayList<>();

        for (User s : followedSellers) {
            PostsListDTO list = new PostsListDTO();
            list.setUserId(s.getId());

            for (Integer id : s.getPosts()) {
                Post p = postsList.get(id);
                if (isPostRecent(p)) {
                    List<PostDTO> posts = list.getPosts();
                    posts.add(new PostDTO(p));

                    // Sort posts by date - newer posts first
                    posts.sort((p1, p2) -> {
                        if (p1.getDate().isBefore(p2.getDate())) {
                            return 1;
                        } else if (p2.getDate().isBefore(p1.getDate())) {
                            return -1;
                        } else {
                            return 0;
                        }
                    });
                }
            }

            if (order.equals("date_asc")) {
                Collections.reverse(list.getPosts());
            } else if (!order.equals("date_desc")) {
                throw new BadRequestException("Order requested is not valid");
            }

            res.add(list);

        }
        return res;
    }

    @Override
    public ResponseEntity<List<PostsListDTO>> getFollowedSellersRecentPosts(Integer userId,
                                                                            String order) {
        if (Objects.isNull(order)) {
            throw new BadRequestException("Order param is required");
        } else if (isUserIdValid(userId)) {
            return new ResponseEntity<>(createPostsListResponse(userId, order),
                    HttpStatus.OK);
        } else {
            throw new NotFoundException("The user does not exist");

        }
    }

    @Override
    public ResponseEntity<String> createPromoPost(PromoPostDTO newPromoPost) {
        HashMap<Integer, User> usersList = repository.getUsers();
        Integer userId = newPromoPost.getUserId();

        if (isUserIdValid(userId)) {
            if (repository.getPromoPosts().containsKey(newPromoPost.getIdPost())) {
                throw new BadRequestException("There's already a promotion post with id_post " + newPromoPost.getIdPost());
            } else {

                User user = usersList.get(userId);
                user.setIsSeller(true);

                user.getPromoPosts().add(newPromoPost.getIdPost());
                repository.addPromoPost(new PromoPost(newPromoPost));

                return new ResponseEntity<>(HttpStatus.OK);
            }
        } else {
            throw new BadRequestException("Given data is not correct");
        }
    }

    @Override
    public ResponseEntity<PromoProductsCountDTO> getPromoProductsCount(Integer userId) {
        HashMap<Integer, User> usersList = repository.getUsers();
        if (isUserIdValid(userId)) {
            User user = usersList.get(userId);
            if (user.getIsSeller()) {
                Integer promoProductsCount = user.getPromoPosts().size();

                PromoProductsCountDTO res = new PromoProductsCountDTO(userId, user.getUserName(),
                        promoProductsCount);
                return new ResponseEntity<>(res, HttpStatus.OK);
            } else {
                throw new BadRequestException("The user is not a seller");
            }
        } else {
            throw new NotFoundException("The user does not exist");
        }
    }

    @Override
    public ResponseEntity<PromoPostsListDTO> getPromoProductsList(Integer userId) {
        HashMap<Integer, User> usersList = repository.getUsers();
        HashMap<Integer, PromoPost> promoPostsList = repository.getPromoPosts();

        if (isUserIdValid(userId)) {
            User user = usersList.get(userId);
            if (user.getIsSeller()) {
                PromoPostsListDTO res = new PromoPostsListDTO(user.getId(), user.getUserName());

                for (Integer id : user.getPromoPosts()) {
                    PromoPostDTO promoPost = new PromoPostDTO(promoPostsList.get(id));
                    res.getPromoPosts().add(promoPost);
                }

                return new ResponseEntity<>(res, HttpStatus.OK);
            } else {
                throw new NotFoundException("The user is not a seller");
            }
        } else {
            throw new NotFoundException("The user does not exist");
        }
    }
}
