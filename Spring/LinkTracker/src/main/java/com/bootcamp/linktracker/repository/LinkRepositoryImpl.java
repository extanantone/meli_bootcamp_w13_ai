package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepositoryImpl implements ILinkReposiroty{

    private Map<Long,Link> links;

    public LinkRepositoryImpl() {
        this.links = new HashMap<>();
    }

    @Override
    public Link createLink(String url) {

        Link link = new Link(url);

        links.put(link.getLinkId(),link);

        return link;
    }

    @Override
    public Link createLink(String url, String pass) {

        Link link = new Link(url,pass);

        links.put(link.getLinkId(),link);

        return link;
    }


    @Override
    /*
     * return Link : The link
     *
     * return null : The link don't exist
     * */
    public Link getLinkbyId(Long linkID) {
        return links.get(linkID);
    }

    @Override
    /*
     * return null : The link don't exist
     *
     * return long : Count of redirects
     * */
    public Long getRedirects(Long linkId) {

        Link link = getLinkbyId(linkId);

        return (link == null)?null:link.getRedirects();
    }

    @Override
    /*
     * return Link : The link has been updated
     *
     * return null : The link don't exist
     * */
    public Link updateLink(Link link) {
        return links.put(link.getLinkId(),link);
    }

    @Override
    /*
     * return null : The link don't exist
     *
     * return true : The link is enabled
     *
     * return false: The link is disabled
     * */
    public Boolean isLinkEnabled(Long idLink) {
        Link link = getLinkbyId(idLink);
        if(link==null){
            return null;
        }else{
            return link.getActive();
        }
    }


}
