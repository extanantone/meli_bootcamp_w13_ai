package ruiz_facundo.Blog.de.iutuber.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EntradaBlogDTO {
    private Long id;
    private String titulo;
    private String autor;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaDePublicacion;

    public EntradaBlogDTO() {}
}
