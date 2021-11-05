package ruiz_facundo.Blog.de.iutuber.service;

import ruiz_facundo.Blog.de.iutuber.dto.EntradaBlogDTO;
import ruiz_facundo.Blog.de.iutuber.model.EntradaBlog;

import java.util.List;

public interface EntradaBlogServiceI {
    EntradaBlogDTO crearNuevoBlog(EntradaBlogDTO inBlog);
    EntradaBlogDTO getBlogById(Long inId);
    List<EntradaBlogDTO> getAllBlogs();
}
