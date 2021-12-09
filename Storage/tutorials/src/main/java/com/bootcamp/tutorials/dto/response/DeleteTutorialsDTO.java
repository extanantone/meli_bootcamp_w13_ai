package com.bootcamp.tutorials.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
public class DeleteTutorialsDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    private String message;

    public DeleteTutorialsDTO(Long id) {
        this.id = id;
        this.message = "The tutorial with id " + this.id + " has been deleted";
    }

    public DeleteTutorialsDTO() {
        this.id = null;
        this.message = "All tutorials has been deleted";
    }
}
