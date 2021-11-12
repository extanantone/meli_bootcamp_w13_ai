package ruiz_facundo.SocialMeli.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ruiz_facundo.SocialMeli.dto.MessageDTO;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<MessageDTO> userIdNotFoundHandler (UserIdNotFoundException e) {
        MessageDTO outMessageDTO = new MessageDTO(e.getMessage());
        return new ResponseEntity<>(outMessageDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FollowFoundException.class)
    public ResponseEntity<MessageDTO> followFoundHandler (FollowFoundException e) {
        MessageDTO outMessageDTO = new MessageDTO(e.getMessage());
        return new ResponseEntity<>(outMessageDTO, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(FollowNotFoundException.class)
    public ResponseEntity<MessageDTO> followNotFoundHandler (FollowNotFoundException e) {
        MessageDTO outMessageDTO = new MessageDTO(e.getMessage());
        return new ResponseEntity<>(outMessageDTO, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(PostFoundException.class)
    public ResponseEntity<MessageDTO> postFoundHandler (PostFoundException e) {
        MessageDTO outMessageDTO = new MessageDTO(e.getMessage());
        return new ResponseEntity<>(outMessageDTO, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidPostException.class)
    public ResponseEntity<MessageDTO> invalidPostHandler (InvalidPostException e) {
        MessageDTO outMessageDTO = new MessageDTO(e.getMessage());
        return new ResponseEntity<>(outMessageDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidSortCriteriaException.class)
    public ResponseEntity<MessageDTO> invalidSortCriteriaHandler (InvalidSortCriteriaException e) {
        MessageDTO outMessageDTO = new MessageDTO(e.getMessage());
        return new ResponseEntity<>(outMessageDTO, HttpStatus.BAD_REQUEST);
    }
}
