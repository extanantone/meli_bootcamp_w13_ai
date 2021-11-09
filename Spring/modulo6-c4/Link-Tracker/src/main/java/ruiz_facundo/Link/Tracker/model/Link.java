package ruiz_facundo.Link.Tracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Link {
    private Long id;
    private String url;
    private String pass;

    public Link() {}

    public Link(Long inId, String inUrl) {
        this.id = inId;
        this.url = inUrl;
    }
}
