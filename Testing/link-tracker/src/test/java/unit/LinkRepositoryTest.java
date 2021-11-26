package unit;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals; // Forma Jeisson
import static org.junit.jupiter.api.Assertions.assertTrue; // Forma Jeisson

import java.util.Optional;


public class LinkRepositoryTest {

    private LinkRepositoryImpl repo = new LinkRepositoryImpl();

    @Test
    public void firstLinkSavedInRepoHasIdZero() {
        LinkDTO newLink = new LinkDTO();
        newLink.setLink("https://www.google.com");
        Integer expectedId = 0;

        LinkDTO savedLink = repo.save(newLink);

        Assertions.assertEquals(expectedId, savedLink.getLinkId());
    }

    @Test
    public void newSavedLinkHasNewId() {
        LinkDTO firstLink = new LinkDTO();
        firstLink.setLink("https://www.google.com");
        LinkDTO secondLink = new LinkDTO();
        secondLink.setLink("https://www.workplace.com");
        /*LinkDTO savedFirstLink =*/ repo.save(firstLink);
        /*LinkDTO savedSecondLink =*/repo.save(secondLink);
        Assertions.assertNotEquals(firstLink.getLinkId(), secondLink.getLinkId());
    }


    @Test
    public void shouldBeDeleteItem(){
        LinkDTO dto =new LinkDTO(2,"https://www.google.com.co",null,0);
        repo.save(dto);
        repo.delete(dto);
        Optional<LinkDTO> opt = repo.findLinkByLinkId(2);
        assertTrue(opt.isEmpty());
    }

    @Test
    public void shouldBeDeleteOneSpecific(){
        LinkDTO dto =new LinkDTO(4,"https://www.google.com.co",null,0);
        repo.save(dto);
        Optional<LinkDTO> dtoOpt = repo.findLinkByLinkId(4);
        assertTrue(dtoOpt.isPresent());
        repo.delete(new LinkDTO(11,"",null,0));
        Optional<LinkDTO> dtoOpt2 = repo.findLinkByLinkId(4);
        assertTrue(dtoOpt2.isPresent());

    }

    @Test
    public void findLinkByLinkIdValidTest()
    {
        LinkDTO dto1 =new LinkDTO(1,"https://www.google.com.co",null,0);
        LinkDTO dto2 =new LinkDTO(2,"https://www.google.com.ar",null,0);
        repo.save(dto1);
        repo.save(dto2);

        Assertions.assertEquals(repo.findLinkByLinkId(1).get(), dto1);
        Assertions.assertEquals(repo.findLinkByLinkId(2).get(), dto2);

    }

   @Test
    public void findLinkByLinkIdNotValidTest()
    {
        LinkDTO dto1 =new LinkDTO(1,"https://www.google.com.co",null,0);
        LinkDTO dto2 =new LinkDTO(2,"https://www.google.com.ar",null,0);
        repo.save(dto1);
        repo.save(dto2);

       Assertions.assertEquals(repo.findLinkByLinkId(3), Optional.empty());
       Assertions.assertEquals(repo.findLinkByLinkId(4), Optional.empty());

    }

    /*@Override
    public Optional<LinkDTO> findLinkByLinkId(Integer linkId) {
        LinkDTO linkDTO = database.get(linkId);
        return Optional.ofNullable(linkDTO);
    }*/




}
