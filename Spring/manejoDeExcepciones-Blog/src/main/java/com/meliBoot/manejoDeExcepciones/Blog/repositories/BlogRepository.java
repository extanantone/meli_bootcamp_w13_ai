package com.meliBoot.manejoDeExcepciones.Blog.repositories;

import com.meliBoot.manejoDeExcepciones.Blog.models.EntradaBlog;
import java.util.List;

public interface BlogRepository {
    List<EntradaBlog> getEntradas();
}
