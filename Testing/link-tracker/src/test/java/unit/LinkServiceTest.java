package unit;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepository;
import com.mercadolibre.linktracker.repositories.LinkRepositoryImpl;
import com.mercadolibre.linktracker.service.LinkService;
import com.mercadolibre.linktracker.service.LinkServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals; // Forma Jeisson
import static org.junit.jupiter.api.Assertions.assertTrue; // Forma Jeisson
import static org.junit.jupiter.api.Assertions.assertNull; // Forma Jeisson

import java.util.Objects;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class LinkServiceTest {

    @Mock
    LinkRepositoryImpl repository;

    @InjectMocks
    LinkServiceImpl service;

    @BeforeEach
    public void restartContMock(){
        Mockito.reset(repository);
    }

    @Test
    public void firstCreatedLinkHasIdZero() {
        LinkDTO firstLink = new LinkDTO();
        LinkDTO savedLink = new LinkDTO();
        savedLink.setLinkId(0);
        Mockito.when(repository.save(firstLink)).thenReturn(savedLink);

        LinkDTO createdLink = service.create(firstLink);

        Mockito.verify(repository,Mockito.atLeastOnce()).
                save(Mockito.any(LinkDTO.class));
        Assertions.assertEquals(savedLink.getLinkId(), createdLink.getLinkId());
    }

    @Test
    public void shouldBeRedirect(){
        String url = "https://www.google.com.co";
        LinkDTO dto = new LinkDTO(1,url,"",0);
        Mockito.when(repository.findLinkByLinkId(1)).thenReturn(Optional.of(dto));
        LinkDTO finalDto = service.redirect(1);
        assertEquals(finalDto,dto);
        Mockito.verify(repository,Mockito.times(1)).findLinkByLinkId(Mockito.anyInt());
        Mockito.verify(repository,Mockito.times(1)).save(Mockito.any(LinkDTO.class));
    }

    @Test
    public void shouldntBeRedirectToInvalidLink(){
        Mockito.when(repository.findLinkByLinkId(1)).thenReturn(Optional.empty());
        assertNull(service.redirect(1));
        Mockito.verify(repository,Mockito.times(1)).findLinkByLinkId(1);
        Mockito.verify(repository,Mockito.times(0)).save(Mockito.any(LinkDTO.class));

    }

    @Test
    public void newCreatedLinkHasDifferentId() {
        LinkDTO firstLink = new LinkDTO();
        firstLink.setLinkId(0);
        LinkDTO secondLink = new LinkDTO();
        secondLink.setLinkId(1);
        LinkDTO firstSavedLink = new LinkDTO();
        firstSavedLink.setLinkId(0);
        LinkDTO secondSavedLink = new LinkDTO();
        secondSavedLink.setLinkId(1);
        Mockito.when(repository.save(firstLink)).thenReturn(firstSavedLink);
        Mockito.when(repository.save(secondLink)).thenReturn(secondSavedLink);

        LinkDTO firstCreatedLink = service.create(firstLink);
        LinkDTO secondCreatedLink = service.create(secondLink);

        Mockito.verify(repository,Mockito.times(2)).
                save(Mockito.any(LinkDTO.class));
        Assertions.assertEquals(firstSavedLink.getLinkId(), firstCreatedLink.getLinkId());
        Assertions.assertEquals(secondSavedLink.getLinkId(), secondCreatedLink.getLinkId());
    }

    @Test
    public void shouldBeRedirectWithValidPassword(){
        LinkDTO dto = new LinkDTO(2,"/power","pass",0);
        Mockito.when(repository.findLinkByLinkId(2)).thenReturn(Optional.of(dto));
        LinkDTO res = service.redirect(2,"pass");
        assertEquals(dto,res);
        Mockito.verify(repository,Mockito.times(1)).findLinkByLinkId(2);
        Mockito.verify(repository,Mockito.times(1)).save(Mockito.any(LinkDTO.class));
    }

    @Test
    public void shouldntBeRedirectWithInvalidPassword(){
        LinkDTO dto = new LinkDTO(5,"/power","pass5",0);
        Mockito.when(repository.findLinkByLinkId(2)).thenReturn(Optional.of(dto));
        LinkDTO res = service.redirect(2,"pass");
        assertNull(res);
        Mockito.verify(repository,Mockito.times(1)).findLinkByLinkId(2);
        Mockito.verify(repository,Mockito.times(0)).save(Mockito.any(LinkDTO.class));
    }

    @Test
    public void invalidateTest() {
        String url = "https://www.google.com.co";
        LinkDTO dto = new LinkDTO(1,url,"",0);

        Mockito.when(repository.findLinkByLinkId(1)).thenReturn(Optional.of(dto));

        service.invalidate(1);

       // Mockito.verify(repository, Mockito.atLeastOnce()).findLinkByLinkId(Mockito.anyInt());
        Mockito.verify(repository, Mockito.times(1)).findLinkByLinkId(Mockito.anyInt());

        //Mockito.when(repository.findLinkByLinkId(1)).thenReturn(Optional.empty());
        //Assertions.assertEquals(repository.findLinkByLinkId(1), Optional.empty());
    }

    @Test
    @DisplayName("when id not exist in invalid method")
    void test1() {

        Integer linkeId = 90;


        Mockito.when(repository.findLinkByLinkId(linkeId)).thenReturn(Optional.empty());

        service.invalidate(linkeId);

        Mockito.verify(repository,Mockito.times(1)).findLinkByLinkId(linkeId);
        Mockito.verify(repository,Mockito.never()).delete(Mockito.any(LinkDTO.class));

    }

    @Test
    public void validLinkIdGetsMetrics() {
        LinkDTO foundLink = new LinkDTO(2,
                "https://www.google.com.ar", null, 0);
        Mockito.when(repository.findLinkByLinkId(2)).thenReturn(Optional.of(foundLink));

        LinkDTO measuredLink = service.metrics(2);

        Assertions.assertEquals(foundLink.getLinkId(), measuredLink.getLinkId());
        Assertions.assertEquals(foundLink.getLink(), measuredLink.getLink());
        Assertions.assertNull(measuredLink.getPassword());
        Assertions.assertEquals(0, measuredLink.getCount());

    }

    @Test
    public void invalidLinkIdGetsNull() {
        Mockito.when(repository.findLinkByLinkId(3)).thenReturn(Optional.empty());

        LinkDTO measuredLink = service.metrics(3);

        Assertions.assertNull(measuredLink);
    }

}
