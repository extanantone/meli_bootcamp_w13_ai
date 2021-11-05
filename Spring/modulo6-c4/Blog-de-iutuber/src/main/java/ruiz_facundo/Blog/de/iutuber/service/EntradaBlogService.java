package ruiz_facundo.Blog.de.iutuber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruiz_facundo.Blog.de.iutuber.dto.EntradaBlogDTO;
import ruiz_facundo.Blog.de.iutuber.exception.DuplicateException;
import ruiz_facundo.Blog.de.iutuber.exception.NotFoundException;
import ruiz_facundo.Blog.de.iutuber.mapper.EntradaMapper;
import ruiz_facundo.Blog.de.iutuber.model.EntradaBlog;
import ruiz_facundo.Blog.de.iutuber.repository.EntradaBlogRepositoryI;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EntradaBlogService implements EntradaBlogServiceI{
    @Autowired
    private EntradaBlogRepositoryI repoDeBlogs;
    @Autowired
    private EntradaMapper mapeador;

    @Override
    public EntradaBlogDTO crearNuevoBlog(EntradaBlogDTO inBlog) {
        EntradaBlog entradaDuplicada = this.repoDeBlogs.findById(inBlog.getId());
        if (!Objects.isNull(entradaDuplicada)) {
            throw new DuplicateException(
                    String.format("La entrada de blog con id %d ya existe", inBlog.getId()));
        }
        EntradaBlog nuevaEntrada = this.repoDeBlogs.nuevoBlog(
                this.mapeador.entradaBlogDTOToEntradaBlog(inBlog)
        );
        return this.mapeador.entradaBlogToEntradaBlogDTO(nuevaEntrada);
    }

    @Override
    public EntradaBlogDTO getBlogById(Long inId) {
        EntradaBlog entradaBuscada = this.repoDeBlogs.findById(inId);
        if (Objects.isNull(entradaBuscada)) {
            throw new NotFoundException(
                    String.format("La entrada de id %d no se encuentra en el repositorio", inId));
        }
        return this.mapeador.entradaBlogToEntradaBlogDTO(entradaBuscada);
    }

    @Override
    public List<EntradaBlogDTO> getAllBlogs() {
        return this.repoDeBlogs.getAllBlogs().stream().map(e ->
                this.mapeador.entradaBlogToEntradaBlogDTO(e)).
                collect(Collectors.toList());
    }
}
