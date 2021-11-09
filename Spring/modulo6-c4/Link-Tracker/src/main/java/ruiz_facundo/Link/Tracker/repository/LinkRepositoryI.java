package ruiz_facundo.Link.Tracker.repository;

import ruiz_facundo.Link.Tracker.dto.LinkDTO;
import ruiz_facundo.Link.Tracker.model.Link;

public interface LinkRepositoryI {
    Integer getRedirectCount(Long linkId);
    Link newLink(String inUrl, String inPass);
    boolean isValidLink(Long linkId);
    boolean isValidPassword(Long linkId, String inPass);
    boolean invalidateLink(Long linkId);
    Link getLinkById(Long linkId);
    void incRedirectCount(Long linkId);
}
