package ruiz_facundo.Blog.de.iutuber.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EntradaBlog {
    private Long id;
    private String titulo;
    private String autor;
    private LocalDate fechaDePublicacion;

    public EntradaBlog() {}

    public EntradaBlog(Long inId, String inTitulo, String inAutor,
                       LocalDate inFechaDePublicacion) {
        this.id = inId;
        this.titulo = inTitulo;
        this.autor = inAutor;
        this.fechaDePublicacion = inFechaDePublicacion;
    }
}
