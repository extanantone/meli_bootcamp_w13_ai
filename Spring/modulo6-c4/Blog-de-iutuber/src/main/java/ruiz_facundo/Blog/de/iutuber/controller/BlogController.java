package ruiz_facundo.Blog.de.iutuber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ruiz_facundo.Blog.de.iutuber.dto.EntradaBlogDTO;
import ruiz_facundo.Blog.de.iutuber.service.EntradaBlogService;

import java.util.List;

@RestController
public class BlogController implements BlogControllerI {
    @Autowired
    private EntradaBlogService servicio;

    @Override
    public EntradaBlogDTO nuevoBlog(EntradaBlogDTO inEntradaBlog) {
        return servicio.crearNuevoBlog(inEntradaBlog);
    }

    @Override
    public EntradaBlogDTO getBlogById(Long inId) {
        return servicio.getBlogById(inId);
    }

    @Override
    public List<EntradaBlogDTO> getAllBlogs() {
        return servicio.getAllBlogs();
    }
}
