package ruiz_facundo.Link.Tracker.service;

import ruiz_facundo.Link.Tracker.dto.LinkDTO;
import ruiz_facundo.Link.Tracker.dto.LinkPostDTO;

public interface LinkServiceI {
    public LinkDTO createLink(LinkPostDTO inLink, String inPass);
    public String redirectLink(Long inId, String inPass);
    public Integer getRedirectCount(Long inId);
    public boolean invalidateLink(Long inId);
}
