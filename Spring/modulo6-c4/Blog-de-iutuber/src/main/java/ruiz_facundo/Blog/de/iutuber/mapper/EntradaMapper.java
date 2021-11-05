package ruiz_facundo.Blog.de.iutuber.mapper;

import org.springframework.stereotype.Component;
import ruiz_facundo.Blog.de.iutuber.dto.EntradaBlogDTO;
import ruiz_facundo.Blog.de.iutuber.model.EntradaBlog;

@Component
public class EntradaMapper {
    public EntradaBlog entradaBlogDTOToEntradaBlog(EntradaBlogDTO inBlogDTO) {
        return new EntradaBlog(inBlogDTO.getId(),
                inBlogDTO.getTitulo(),
                inBlogDTO.getAutor(),
                inBlogDTO.getFechaDePublicacion());
    }

    public EntradaBlogDTO entradaBlogToEntradaBlogDTO(EntradaBlog inBlog) {
        return new EntradaBlogDTO(inBlog.getId(),
                inBlog.getTitulo(),
                inBlog.getAutor(),
                inBlog.getFechaDePublicacion());
    }
}
