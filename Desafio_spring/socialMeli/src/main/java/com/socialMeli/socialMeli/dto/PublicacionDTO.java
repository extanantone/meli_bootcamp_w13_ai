package com.socialMeli.socialMeli.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
@AllArgsConstructor
public class PublicacionDTO {
    private int user_id;
    private int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductoDTO detail;
    private int category;
    private double price;

    public PublicacionDTO() {
        this.detail = new ProductoDTO();
    }
}
