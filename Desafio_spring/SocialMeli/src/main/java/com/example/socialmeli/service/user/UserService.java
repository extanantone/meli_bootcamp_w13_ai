package com.example.socialmeli.service.user;

import com.example.socialmeli.dto.FollowedListDTO;
import com.example.socialmeli.dto.FollowerCountDTO;
import com.example.socialmeli.dto.FollowerListDTO;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.user.IUserRepository;
import org.modelmapper.Converter;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.Map;

@Service
public class UserService implements IUserService
{
    @Autowired
    IUserRepository userRepository;

    @Override
    public FollowedListDTO followed(int userId, String order)
    {
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(userId))
            throw new BadRequestException("Usuario no encontrado");

        User user;
        user = userMap.get(userId);
        if (order != null)
        {
            if (order.equals("name_asc"))
                user.setFollowed(userRepository.findFollowedOrderByNameAsc(userId));
            else if (order.equals("name_desc"))
                user.setFollowed(userRepository.findFollowedOrderByNameDesc(userId));
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, FollowedListDTO.class);
    }

    @Override
    public FollowerListDTO followers(int userId, String order)
    {
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(userId))
            throw new BadRequestException("Usuario no encontrado");

        User user;
        user = userMap.get(userId);
        if (order != null)
        {
            if (order.equals("name_asc"))
                user.setFollowers(userRepository.findFollowersOrderByNameAsc(userId));
            else if (order.equals("name_desc"))
                user.setFollowers(userRepository.findFollowersOrderByNameDesc(userId));
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, FollowerListDTO.class);
    }

    @Override
    public FollowerCountDTO countFollowers(int userId)
    {
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(userId))
            throw new BadRequestException("Usuario no encontrado");

        User user;
        user = userMap.get(userId);
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<User, FollowerCountDTO> propertyMapper = modelMapper.createTypeMap(User.class, FollowerCountDTO.class);
        Converter<Collection, Integer> collectionToSize = c -> c.getSource().size();
        propertyMapper.addMappings(
                mapper -> mapper.using(collectionToSize).map(User::getFollowers, FollowerCountDTO::setFollowersCount)
        );
        return modelMapper.map(user, FollowerCountDTO.class);
    }

    @Override
    public FollowerListDTO follow(int userId, int userIdToFollow)
    {
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(userId) || !userMap.containsKey(userIdToFollow))
            throw new BadRequestException("Usuario no encontrado");

        User user, userToFollow;
        user = userMap.get(userId);
        userToFollow = userMap.get(userIdToFollow);
        if (!user.follow(userToFollow))
            throw new BadRequestException("No puedes seguir a este usuario");

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, FollowerListDTO.class);
    }

    @Override
    public FollowerListDTO unfollow(int userId, int userIdToUnfollow)
    {
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(userId) || !userMap.containsKey(userIdToUnfollow))
            throw new BadRequestException("Usuario no encontrado");

        User user, userToUnfollow;
        user = userMap.get(userId);
        userToUnfollow = userMap.get(userIdToUnfollow);
        if (!user.unfollow(userToUnfollow))
            throw new BadRequestException("No puedes dejar de seguir a este usuario");

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, FollowerListDTO.class);
    }
}
