package com.example.socialmeli.mapper;

import com.example.socialmeli.dto.user.FollowerDTO;
import com.example.socialmeli.model.User;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class FollowerMapper
{
    public List<FollowerDTO> UserToFollowerDTO(List<User> users)
    {
        List<FollowerDTO> followerDTOList = new LinkedList<>();
        for (User user: users)
        {
            FollowerDTO followerDTO = new FollowerDTO();
            followerDTO.setUserId(user.getUserId());
            followerDTO.setUserName(user.getUserName());
            followerDTOList.add(followerDTO);
        }
        return followerDTOList;
    }
}
