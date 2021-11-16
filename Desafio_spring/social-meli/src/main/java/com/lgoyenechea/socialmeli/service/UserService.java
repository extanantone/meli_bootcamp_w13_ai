package com.lgoyenechea.socialmeli.service;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.dto.mapper.UserMapper;
import com.lgoyenechea.socialmeli.exception.UserDoesNotFollowException;
import com.lgoyenechea.socialmeli.model.User;
import com.lgoyenechea.socialmeli.exception.UserArgumentNotValidException;
import com.lgoyenechea.socialmeli.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO save(UserCreationDTO newUser) throws UserArgumentNotValidException {
        if (newUser.getUserName() == null || newUser.getUserName().equals(""))
            throw new UserArgumentNotValidException("Invalid user name.");

        User user = userRepository.save(UserMapper.userCreationDtoToUser(newUser));
        return UserMapper.userToDto(user);
    }

    public UserFollowDTO follow(Long userId, Long userIdToFollow) throws UserArgumentNotValidException {
        if (userId.equals(userIdToFollow))
            throw new UserArgumentNotValidException("Users id cannot match.");

        User user = userRepository.getById(userId);
        User followed = userRepository.getById(userIdToFollow);

        if (user == null || followed == null)
            throw new UserArgumentNotValidException("Invalid user id.");

        if (!user.getFollowed().contains(followed.getId())) {
            user.getFollowed().add(followed.getId());
            followed.getFollowers().add(user.getId());
        }
        return UserMapper.userToFollow(user, followed);
    }

    public UserFollowersCountDTO followersCount(Long userId) throws UserArgumentNotValidException {
        User user = userRepository.getById(userId);
        if (user == null) throw new UserArgumentNotValidException("Invalid user id.");
        return UserMapper.userToFollowersCount(user);
    }

    public UserFollowersListDTO followersList(Long userId, String order) throws UserArgumentNotValidException {
        User user = userRepository.getById(userId);
        if (user == null) throw new UserArgumentNotValidException("Invalid user id.");

        List<User> followers = user.getFollowers().stream()
                .map(userRepository::getById)
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());

        if (order.equals("name_desc"))
            followers = followers.stream()
                    .sorted(Comparator.comparing(User::getName).reversed())
                    .collect(Collectors.toList());

        return UserMapper.userToFollowersList(user, followers);
    }

    public UserFollowedListDTO followedList(Long userId, String order) throws UserArgumentNotValidException {
        User user = userRepository.getById(userId);
        if (user == null) throw new UserArgumentNotValidException("Invalid user id.");

        List<User> followed = user.getFollowed().stream()
                .map(userRepository::getById)
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());

        if (order.equals("name_desc"))
            followed = followed.stream()
                    .sorted(Comparator.comparing(User::getName).reversed())
                    .collect(Collectors.toList());

        return UserMapper.userToFollowedList(user, followed);
    }

    public UserUnfollowDTO unfollow(Long userId, Long userIdToUnfollow)
            throws UserArgumentNotValidException, UserDoesNotFollowException {
        if (userId.equals(userIdToUnfollow))
            throw new UserArgumentNotValidException("Users id cannot match.");

        User user = userRepository.getById(userId);
        User userToUnfollow = userRepository.getById(userIdToUnfollow);

        if (user == null || userToUnfollow == null)
            throw new UserArgumentNotValidException("Invalid user id.");

        if (user.getFollowed().contains(userToUnfollow.getId())) {
            user.getFollowed().remove(userToUnfollow.getId());
            userToUnfollow.getFollowers().remove(user.getId());
            return UserMapper.unfollowToDto(user, userToUnfollow);
        }

        throw  new UserDoesNotFollowException(
                String.format("User with id %s does not follow user with id %s",
                        userId, userIdToUnfollow)
        );
    }
}
