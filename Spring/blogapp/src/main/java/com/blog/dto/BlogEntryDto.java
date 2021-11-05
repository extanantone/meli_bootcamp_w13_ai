package com.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntryDto {
    private int id;
    private String name;
    private String authorName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate publishDate;
}
