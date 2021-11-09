package ruiz_facundo.Link.Tracker.mapper;

import org.springframework.stereotype.Component;
import ruiz_facundo.Link.Tracker.dto.LinkDTO;
import ruiz_facundo.Link.Tracker.dto.LinkPassDTO;
import ruiz_facundo.Link.Tracker.model.Link;

import java.util.Objects;

@Component
public class LinkMapper {
    public LinkDTO LinkToLinkDTO (Link inLink) {
        if (Objects.isNull(inLink.getPass())) {
            return new LinkDTO(inLink.getId(), inLink.getUrl());
        } else {
            return new LinkPassDTO(inLink.getId(),
                    inLink.getUrl(), inLink.getPass());
        }
    }
}
