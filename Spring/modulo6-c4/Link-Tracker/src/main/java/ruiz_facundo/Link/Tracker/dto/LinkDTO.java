package ruiz_facundo.Link.Tracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkDTO {
    private Long id;
    private String url;

    public LinkDTO() {}

    public LinkDTO(Long inId, String inUrl) {
        this.id = inId;
        this.url = inUrl;
    }
}
