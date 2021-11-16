package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.ReqProductDTO;
import com.bootcamp.socialmeli.dto.UserPostDTO;

public interface IPostService {
    public void createNewPost(ReqProductDTO reqProductDTO);
    public UserPostDTO getRecientPost(Long idUser, String prefix);
}
