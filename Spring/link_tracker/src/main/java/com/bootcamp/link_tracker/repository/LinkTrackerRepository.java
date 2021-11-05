package com.bootcamp.link_tracker.repository;

import com.bootcamp.link_tracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository{
    private List<Link> listaLinks;

    public LinkTrackerRepository() {
        this.listaLinks = new ArrayList<>();
    }

    @Override
    public void buscarLink() {

    }

    @Override
    public void guardarLink(Link link) {
        this.listaLinks.add(link);
    }

    @Override
    public void eliminarLink(Integer id) {
        //this.listaLinks.stream().filter(x -> x.getId().equals(id)).findFirst().orElse();//FIXME
        for (Link i : this.listaLinks) {
            if(i.getId().equals(id)){
                this.listaLinks.remove(i);
            }
            break;
        }
    }
}
