package ruiz_facundo.Link.Tracker.service;

import org.springframework.stereotype.Service;
import ruiz_facundo.Link.Tracker.dto.LinkDTO;
import ruiz_facundo.Link.Tracker.dto.LinkPostDTO;
import ruiz_facundo.Link.Tracker.exception.InvalidPasswordException;
import ruiz_facundo.Link.Tracker.exception.NotFoundException;
import ruiz_facundo.Link.Tracker.mapper.LinkMapper;
import ruiz_facundo.Link.Tracker.model.Link;
import ruiz_facundo.Link.Tracker.repository.LinkRepositoryI;

import java.util.Objects;

@Service
public class LinkService implements LinkServiceI {
    private final LinkRepositoryI repoDeLinks;
    private final LinkMapper mapeador;

    public LinkService(LinkRepositoryI repoDeLinks, LinkMapper mapeador) {
        this.repoDeLinks = repoDeLinks;
        this.mapeador = mapeador;
    }

    @Override
    public LinkDTO createLink(LinkPostDTO inLink, String inPass) {
        // Validar link
        Link outLink = repoDeLinks.newLink(inLink.getUrl(), inPass);
        return this.mapeador.LinkToLinkDTO(outLink);
    }

    @Override
    public String redirectLink(Long inId, String inPass) {
        if (!this.repoDeLinks.isValidLink(inId)) {
            throw new NotFoundException(String.format("Id %d inválido", inId));
        }
        if (!this.repoDeLinks.isValidPassword(inId, inPass)) {
            throw new InvalidPasswordException(
                    String.format("Contraseña inválida para el link %d", inId));
        }
        this.repoDeLinks.incRedirectCount(inId);
        return this.repoDeLinks.getLinkById(inId).getUrl();
    }

    @Override
    public Integer getRedirectCount(Long inId) {
        Integer outRedirectCount = this.repoDeLinks.getRedirectCount(inId);
        if (Objects.isNull(outRedirectCount)) {
            throw new NotFoundException(String.format("Link id %d no encontrado", inId));
        }
        return outRedirectCount;
    }

    @Override
    public boolean invalidateLink(Long inId) {
        if (!this.repoDeLinks.isValidLink(inId)) {
            throw new NotFoundException(String.format("Id %d ya inválido", inId));
        }
        return this.repoDeLinks.invalidateLink(inId);
    }
}
