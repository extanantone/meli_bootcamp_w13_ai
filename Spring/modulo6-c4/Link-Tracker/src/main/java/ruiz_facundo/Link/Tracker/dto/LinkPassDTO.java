package ruiz_facundo.Link.Tracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkPassDTO extends LinkDTO {
    private String pass;

    public LinkPassDTO() {}

    public LinkPassDTO(Long inId, String inUrl, String inPass) {
        super(inId, inUrl);
        this.pass = inPass;
    }
}
