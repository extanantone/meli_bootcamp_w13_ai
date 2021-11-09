package ruiz_facundo.Link.Tracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkPostDTO {
    String url;

    public LinkPostDTO() {}

    public LinkPostDTO(String inUrl) {
        this.url = inUrl;
    }
}
