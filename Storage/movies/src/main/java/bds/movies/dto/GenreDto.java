package bds.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class GenreDto {
    String name;
    Integer ranking;
    Short active;
}
