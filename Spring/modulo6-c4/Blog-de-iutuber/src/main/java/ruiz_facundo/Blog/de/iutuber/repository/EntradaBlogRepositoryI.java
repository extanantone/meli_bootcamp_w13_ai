package ruiz_facundo.Blog.de.iutuber.repository;

import ruiz_facundo.Blog.de.iutuber.dto.EntradaBlogDTO;
import ruiz_facundo.Blog.de.iutuber.model.EntradaBlog;

import java.util.List;

public interface EntradaBlogRepositoryI {
    public EntradaBlog nuevoBlog(EntradaBlog nuevaEntrada);
    public EntradaBlog findById(Long inId);
    public List<EntradaBlog> getAllBlogs();
}
