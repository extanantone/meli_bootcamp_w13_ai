package ruiz_facundo.Blog.de.iutuber.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ruiz_facundo.Blog.de.iutuber.dto.EntradaBlogDTO;

import java.util.List;

public interface BlogControllerI {
    @PostMapping("/blog")
    EntradaBlogDTO nuevoBlog(@RequestBody EntradaBlogDTO inEntradaBlog);
    @GetMapping("/blog/{id}")
    EntradaBlogDTO getBlogById(@PathVariable("id") Long inId);
    @GetMapping("/blogs")
    List<EntradaBlogDTO> getAllBlogs();
}
