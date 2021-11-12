package SocialMeli.exception;

import SocialMeli.dto.response.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(AlredyFollowedException.class)
    public ResponseEntity<ExceptionDTO> alreadyFollowedException(){
        return new ResponseEntity<>(new ExceptionDTO("Seller had already been followed by customer"), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(WrongIdException.class)
    public ResponseEntity<ExceptionDTO> wrongIdException(WrongIdException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMsg() + " does not exist"), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RepeatedIdException.class)
    public ResponseEntity<ExceptionDTO> repeatIdException(){
        return new ResponseEntity<>(new ExceptionDTO("Id has already been taken"), HttpStatus.BAD_REQUEST);
    }


}
