package com.bootcamp.socialmeliSprint1.exception;

import com.bootcamp.socialmeliSprint1.dto.response.error.ErrorDTO;
import com.bootcamp.socialmeliSprint1.exception.sortException.BadSorterParamRequest;
import com.bootcamp.socialmeliSprint1.exception.userException.NotFoundFollower;
import com.bootcamp.socialmeliSprint1.exception.userException.NotFoundUsuarioException;
import com.bootcamp.socialmeliSprint1.exception.userException.PurchaserAlreadyFollowSeller;
import com.bootcamp.socialmeliSprint1.exception.postException.PostIdAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionSocialMeliHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validatingDataTypes(MethodArgumentNotValidException exception){

        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setCode("Payload's field Not Valid Exception");

        errorDTO.setMessage("There are some fields that don't respect validations.");

        HashMap<String, List<String>> errors = new HashMap<>();

        exception.getFieldErrors().forEach( e-> {
            String field = e.getField();
            String msg = e.getDefaultMessage();

            errors.compute(field,($,l) ->
                    new ArrayList<>(){
                        {
                            addAll(!Objects.isNull(l) ? l : new ArrayList<>());
                            add(field + " : " + msg);
                        }
                    });
        });
        errorDTO.setErrors(errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }




    @ExceptionHandler(NotFoundUsuarioException.class)
    public ResponseEntity<ErrorDTO> NotFoundUser(NotFoundUsuarioException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 400: Not_found_user",
                        e.getMessage() ),
                HttpStatus.resolve(400));

    }

    @ExceptionHandler(PostIdAlreadyExists.class)
    public ResponseEntity<ErrorDTO> PostAlreadyExists(PostIdAlreadyExists e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 400: Post_already_exists",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NotFoundFollower.class)
    public ResponseEntity<ErrorDTO> NotFoundFollower(NotFoundFollower e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 404: Follower_No_exists",
                        e.getMessage() ),
                HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(PurchaserAlreadyFollowSeller.class)
    public ResponseEntity<ErrorDTO> PurchaserAlreadyFollowSeller(PurchaserAlreadyFollowSeller e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 400: Seller_already_follow",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadSorterParamRequest.class)
    public ResponseEntity<ErrorDTO> BadSorterParamRequest(BadSorterParamRequest e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 400: Invalid_Sort_Param",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST);

    }

}
