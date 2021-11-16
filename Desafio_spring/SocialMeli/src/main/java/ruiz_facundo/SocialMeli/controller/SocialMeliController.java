package ruiz_facundo.SocialMeli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruiz_facundo.SocialMeli.dto.*;
import ruiz_facundo.SocialMeli.service.SocialMeliServiceI;

@RestController
public class SocialMeliController implements SocialMeliControllerI {
    @Autowired
    SocialMeliServiceI socialMeliService;

    @Override
    public ResponseEntity<MessageDTO> addFollow(Long idFollower, Long idFollowed) {
        this.socialMeliService.follow(idFollower, idFollowed);
        MessageDTO outMessage = new MessageDTO("Seguimiento procesado con éxito");
        return new ResponseEntity(outMessage, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MessageDTO> removeFollow (Long idFollower, Long idFollowed) {
        this.socialMeliService.unfollow(idFollower, idFollowed);
        MessageDTO outMessage = new MessageDTO("Seguimiento eliminado con éxito");
        return new ResponseEntity(outMessage, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserFollowersCountDTO> getFollowersCountOf (Long idUser) {
        return new ResponseEntity(this.socialMeliService.getFollowersCount(idUser), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserFollowersDTO> getFollowersOf (Long idUser, String criteria) {
        return new ResponseEntity(this.socialMeliService.getFollowers(idUser, criteria),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserFollowedDTO> getFollowedBy (Long idUser, String orientation) {
        return new ResponseEntity(this.socialMeliService.getFollowed(idUser, orientation),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MessageDTO> addNewPost(RequestPostDTO newPostReq) {
        this.socialMeliService.publish(newPostReq);
        MessageDTO outMessage = new MessageDTO("Publicación subida con éxito");
        return new ResponseEntity<>(outMessage, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserPostsDTO> getRecentPostsByFollowed (Long idUser, String orientation) {
        return new ResponseEntity(this.socialMeliService.getRecentPosts(idUser, orientation),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MessageDTO> publishPromo (RequestPromotionDTO newPromoReq) {
        this.socialMeliService.publishPromo(newPromoReq);
        MessageDTO outMessage = new MessageDTO("Promoción subida con éxito");
        return new ResponseEntity(outMessage, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserPromoCountDTO> getPromotionsCountOf (Long idUser) {
        return new ResponseEntity(this.socialMeliService.getPromosCount(idUser), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserNamePostsDTO> getPromotionsOf(Long idUser, String orientation) {
        return new ResponseEntity(this.socialMeliService.getPromoPosts(idUser, orientation),
                HttpStatus.OK);
    }
}
