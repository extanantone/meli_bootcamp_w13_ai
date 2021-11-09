package ruiz_facundo.Link.Tracker.repository;

import org.springframework.stereotype.Repository;
import ruiz_facundo.Link.Tracker.model.Link;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class LinkRepository implements LinkRepositoryI {
    private Map<Long, Integer> redirectCount;
    private Map<Long, Link> validLinks;
    private Long lastId;

    public LinkRepository() {
        this.redirectCount = new HashMap<>();
        this.validLinks = new HashMap<>();
        this.lastId = (long) 0;
    }

    private Long getNextId() {
        this.lastId++;
        return this.lastId;
    }

    @Override
    public Integer getRedirectCount(Long linkId) {
        return this.redirectCount.get(linkId);
    }

    @Override
    public Link newLink(String inUrl, String inPass) {
        Link newLink = new Link(this.getNextId(), inUrl, inPass);
        this.redirectCount.put(newLink.getId(),0);
        this.validLinks.put(newLink.getId(),newLink);
        return newLink;
    }

    @Override
    public boolean isValidLink(Long linkId) {
        Link validLink = this.validLinks.get(linkId);
        return !Objects.isNull(validLink);
    }

    @Override
    public boolean invalidateLink(Long linkId) {
        Link linkRemoved = this.validLinks.remove(linkId);
        return !Objects.isNull(linkRemoved);
    }

    @Override
    public Link getLinkById(Long linkId) {
        return this.validLinks.get(linkId);
    }

    @Override
    public void incRedirectCount(Long linkId) {
        this.redirectCount.put(linkId,this.redirectCount.get(linkId)+1);
    }

    @Override
    public boolean isValidPassword(Long linkId, String inPass) {
        Link foundLink = this.getLinkById(linkId);
        return Objects.isNull(foundLink.getPass()) ||
                foundLink.getPass().equals(inPass);
    }
}
