package bootcamp.SocialMeli.controller;
import bootcamp.SocialMeli.services.IService;
import bootcamp.SocialMeli.services.Services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    public IService iService;

    public Controller(IService iService){
    this.iService = iService;
    }

    @PostMapping (path = "/users/{user_id}/follow/{user_id_to_follow}")
    @ResponseStatus(HttpStatus.OK)
    public void follow (@PathVariable int user_id, @PathVariable int user_id_to_follow){
        iService.followUser(user_id, user_id_to_follow);


    }

}
