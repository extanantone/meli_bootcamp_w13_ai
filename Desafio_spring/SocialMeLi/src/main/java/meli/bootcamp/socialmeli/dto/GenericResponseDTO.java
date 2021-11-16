package meli.bootcamp.socialmeli.dto;

import java.util.HashMap;

public class GenericResponseDTO {
    private HashMap<String,String> response;

    public GenericResponseDTO(HashMap<String, String> response) {
        this.response = response;
    }

    public GenericResponseDTO() {
    }

    public HashMap<String, String> getResponse() {
        return response;
    }

    public void setResponse(HashMap<String, String> response) {
        this.response = response;
    }
}
