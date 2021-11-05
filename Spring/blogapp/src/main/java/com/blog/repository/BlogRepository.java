package com.blog.repository;

import com.blog.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository{

    private List<BlogEntry> entrys;

    public BlogRepository(){
        entrys = new ArrayList<>();
        entrys.add(new BlogEntry(1,"TEST","Juan", LocalDate.now()));
    }

    @Override
    public BlogEntry findById(int id) {
        return entrys.stream().filter(i->i.getId()==id)
                .findFirst().orElse(null);
    }

    @Override
    public void addBlogEntry(BlogEntry entry) {
        entrys.add(entry);
    }
}
