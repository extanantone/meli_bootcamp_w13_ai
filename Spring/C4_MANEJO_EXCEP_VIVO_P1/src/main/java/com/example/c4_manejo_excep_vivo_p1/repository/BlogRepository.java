package com.example.c4_manejo_excep_vivo_p1.repository;
import com.example.c4_manejo_excep_vivo_p1.model.EntradaBlog;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@Repository
@Getter
public class BlogRepository implements IBlogRepository
{
    private Map<Long, EntradaBlog> entradaBlogMap;

    public BlogRepository()
    {
        this.entradaBlogMap = new HashMap<>();
    }

    @Override
    public Map<Long, EntradaBlog> getMap()
    {
        return this.entradaBlogMap;
    }

    @Override
    public List<EntradaBlog> getBlogs()
    {
        return new ArrayList<>(entradaBlogMap.values());
    }

    @Override
    public void saveBlog(EntradaBlog entradaBlog)
    {
        entradaBlogMap.put(entradaBlog.getId(), entradaBlog);
    }
}
