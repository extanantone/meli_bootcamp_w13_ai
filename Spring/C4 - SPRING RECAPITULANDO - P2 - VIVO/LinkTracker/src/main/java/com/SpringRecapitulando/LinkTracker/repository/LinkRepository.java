package com.SpringRecapitulando.LinkTracker.repository;

import com.SpringRecapitulando.LinkTracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class LinkRepository implements ILinkRepository{
    private Integer id = 4;
    List<Link> links = new ArrayList<Link>(){{
        add(new Link(1,"www.google.com", 0, true, "123"));
        add(new Link(2,"www.youtube.com", 0, true, "456"));
        add(new Link(3,"www.facebook.com", 0, false, "789"));
    }};

    @Override
    public Link findById(int linkId) {
        return this.links.stream().filter(link -> link.getId() == linkId).findFirst().orElse(null);
    }

    @Override
    public Link createLink(Link link) {
        Link existsLink = this.links.stream().filter(l -> l.getUrl().toLowerCase().equals(link.getUrl().toLowerCase())).findFirst().orElse(null);
        if (existsLink != null) {
            return null;
        }
        link.setId(this.id++);
        link.setValidate(true);
        link.setViews(0);
        this.links.add(link);
        return link;
    }

    @Override
    public Link invalidateLink(int id) {
        Link existsLink = this.links.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
        if (existsLink != null) {
            existsLink.setValidate(false);
        }
        return existsLink;
    }

    @Override
    public Link addView(int linkId) {
        Link existsLink = this.links.stream().filter(l -> l.getId() == linkId).findFirst().orElse(null);
        if (existsLink != null) {
            existsLink.setViews(existsLink.getViews()+1);
        }
        return existsLink;
    }
}
