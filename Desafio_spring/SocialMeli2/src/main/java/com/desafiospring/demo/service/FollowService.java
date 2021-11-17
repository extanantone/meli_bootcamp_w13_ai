package com.desafiospring.demo.service;

import com.desafiospring.demo.DTO.UserSellerFollowersCountDTO;
import com.desafiospring.demo.exception.handle.BadRequestException;
import com.desafiospring.demo.mapper.IMapper;
import com.desafiospring.demo.model.User;
import com.desafiospring.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowService implements IFollowService {
    //de esta forma me traigo el repositorio

    UserRepository repository;
    IMapper mapper;
//constructor(es la inyecccion de dependencias)

    public FollowService(UserRepository repository, IMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //hicimos la logica de agregarle al vendedor el usuario que nos sigue y usamos el repositorio.
    public void FollowSeller(int userId, int userIdToFollow) {
        repository.AddFollow(userId, userIdToFollow);

    }

    public UserSellerFollowersCountDTO countFollowers(int userId){
        User user = repository.FindSeller(userId);

          return new UserSellerFollowersCountDTO(
                  userId,
                  user.getName(),
                  getFollowersCount(userId)
          );
    }
    public int getFollowersCount(int userId){
        return repository.CountFollowers(userId);
   }


   public void unFollowers(int userId, int userIdToUnfollow) {
        User follower = repository.FindSeller(userId);
        User followed = repository.FindSeller(userIdToUnfollow);
        if(followed.getFollowers().contains(follower)){
           follower.getFollower().remove(followed);
           followed.getFollowers().remove(follower);
        } else {
            throw new BadRequestException("El usuario no es seguidor");

        }
  }

}


