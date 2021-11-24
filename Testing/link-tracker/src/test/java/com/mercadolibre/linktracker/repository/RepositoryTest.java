package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepository;
import com.mercadolibre.linktracker.repositories.LinkRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepositoryTest {

    private LinkRepository repository = new LinkRepositoryImpl();

    @Test
    public void shouldFindExistLink(){
        repository.save(new LinkDTO(1,"/app","",0));
        Optional<LinkDTO> link = repository.findLinkByLinkId(1);
        assertTrue(link.isPresent());
        assertEquals(link.get().getLink(),"/app");
        assertEquals(link.get().getCount(),0);
        assertEquals(link.get().getPassword(),"");
    }

    @Test
    public void shouldFinUnexistLinkById(){
        Optional<LinkDTO> dto = repository.findLinkByLinkId(70);
        assertTrue(dto.isEmpty());
    }

    @Test
    public void shouldBeDeleteItem(){
        LinkDTO dto =new LinkDTO(2,"https://www.google.com.co",null,0);
        repository.save(dto);
        Optional<LinkDTO> tmp = repository.findLinkByLinkId(2);
        assertTrue(tmp.isPresent());
        repository.delete(dto);
        Optional<LinkDTO> opt = repository.findLinkByLinkId(2);
        assertTrue(opt.isEmpty());
    }

    @Test
    public void newSavedLinkHasNewId() {
        LinkDTO firstLink = new LinkDTO();
        firstLink.setLink("https://www.google.com");
        LinkDTO secondLink = new LinkDTO();
        secondLink.setLink("https://www.workplace.com");
        LinkDTO savedFirstLink = repository.save(firstLink);
        LinkDTO savedSecondLink = repository.save(secondLink);
        Assertions.assertNotEquals(savedFirstLink.getLinkId(), secondLink.getLinkId());
    }

    @Test
    public void shouldBeDeleteOneSpecific(){
        LinkDTO dto =new LinkDTO(4,"https://www.google.com.co",null,0);
        repository.save(dto);
        Optional<LinkDTO> dtoOpt = repository.findLinkByLinkId(4);
        assertTrue(dtoOpt.isPresent());
        repository.delete(new LinkDTO(11,"",null,0));
        Optional<LinkDTO> dtoOpt2 = repository.findLinkByLinkId(4);
        assertTrue(dtoOpt2.isPresent());

    }

    @Test
    public void findLinkByLinkIdNotValidTest()
    {
        LinkDTO dto1 =new LinkDTO(1,"https://www.google.com.co",null,0);
        LinkDTO dto2 =new LinkDTO(2,"https://www.google.com.ar",null,0);
        repository.save(dto1);
        repository.save(dto2);

        assertEquals(repository.findLinkByLinkId(3), Optional.empty());
        assertEquals(repository.findLinkByLinkId(4), Optional.empty());

    }




}
