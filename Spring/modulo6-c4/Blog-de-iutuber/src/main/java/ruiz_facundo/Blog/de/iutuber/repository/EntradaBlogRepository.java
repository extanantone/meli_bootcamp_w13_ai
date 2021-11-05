package ruiz_facundo.Blog.de.iutuber.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ruiz_facundo.Blog.de.iutuber.dto.EntradaBlogDTO;
import ruiz_facundo.Blog.de.iutuber.model.EntradaBlog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class EntradaBlogRepository implements EntradaBlogRepositoryI {
    private Map<Long, EntradaBlog> blogs = new HashMap<>();

    @Override
    public EntradaBlog nuevoBlog(EntradaBlog nuevaEntrada) {
        Long newId = nuevaEntrada.getId();
        this.blogs.put(newId, nuevaEntrada);
        return nuevaEntrada;
    }

    @Override
    public EntradaBlog findById(Long inId) {
        return this.blogs.get(inId);
    }

    @Override
    public List<EntradaBlog> getAllBlogs() {
        return this.blogs.entrySet().stream().map(e -> {
            e.getValue().setId(e.getKey());
            return e.getValue();
        }).collect(Collectors.toList());
    }
}
