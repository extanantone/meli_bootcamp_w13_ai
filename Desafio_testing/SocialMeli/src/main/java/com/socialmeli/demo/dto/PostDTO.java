package com.socialmeli.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.socialmeli.demo.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    @NotNull(message = "The user_id cannot be empty")
    @Positive(message = "The user_id cannot be zero")
    private Integer userId;

    @NotNull(message = "The post_id cannot be empty")
    @Positive(message = "The post_id cannot be zero")
    private Integer postId;

    private String userName;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "The date cannot be empty")
    private LocalDate date;

    @Valid
    private Product detail;

    @NotNull(message = "The category cannot be empty")
    private Integer category;

    @NotNull(message = "The price cannot be empty")
    @Max(value = 10000000, message = "The max price is 10.000.000")
    private Double price;
}
