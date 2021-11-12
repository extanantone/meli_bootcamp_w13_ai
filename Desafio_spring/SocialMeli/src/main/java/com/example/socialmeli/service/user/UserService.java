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
    public FollowedListDTO followed(int user_id)
    {
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(user_id))
            throw new BadRequestException("Usuario no encontrado");

        User user;
        user = userMap.get(user_id);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, FollowedListDTO.class);
    }

    @Override
    public FollowerListDTO followers(int user_id)
    {
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(user_id))
            throw new BadRequestException("Usuario no encontrado");

        User user;
        user = userMap.get(user_id);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, FollowerListDTO.class);
    }

    @Override
    public FollowerCountDTO countFollowers(int user_id)
    {
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(user_id))
            throw new BadRequestException("Usuario no encontrado");

        User user;
        user = userMap.get(user_id);
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<User, FollowerCountDTO> propertyMapper = modelMapper.createTypeMap(User.class, FollowerCountDTO.class);
        Converter<Collection, Integer> collectionToSize = c -> c.getSource().size();
        propertyMapper.addMappings(
                mapper -> mapper.using(collectionToSize).map(User::getFollowers, FollowerCountDTO::setFollowersCount)
        );
        return modelMapper.map(user, FollowerCountDTO.class);
    }

    @Override
    public FollowerListDTO follow(int user_id, int user_id_to_follow)
    {
        Map<Integer, User> userMap = userRepository.usersMap();
        if (!userMap.containsKey(user_id) || !userMap.containsKey(user_id_to_follow))
            throw new BadRequestException("Usuario no encontrado");

        User user, userToFollow;
        user = userMap.get(user_id);
        userToFollow = userMap.get(user_id_to_follow);
        if (!user.follow(userToFollow))
            throw new BadRequestException("No puedes seguir a este usuario");

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, FollowerListDTO.class);
    }
}
