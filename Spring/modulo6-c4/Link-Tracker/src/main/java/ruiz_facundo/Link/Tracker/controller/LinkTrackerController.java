package ruiz_facundo.Link.Tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruiz_facundo.Link.Tracker.dto.LinkDTO;
import ruiz_facundo.Link.Tracker.dto.LinkPostDTO;
import ruiz_facundo.Link.Tracker.service.LinkServiceI;

import java.net.URI;

@RestController
public class LinkTrackerController {
    private final LinkServiceI servicio;

    public LinkTrackerController(LinkServiceI servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/link")
    public LinkDTO createLink(@RequestBody LinkPostDTO inLink,
                              @RequestParam(required = false) String pass) {
        return this.servicio.createLink(inLink, pass);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<?> redirectLink(@PathVariable("id") Long inId,
            @RequestParam(required = false) String pass) {
        HttpHeaders outHeaders = new HttpHeaders();
        outHeaders.setLocation(URI.create(this.servicio.redirectLink(inId, pass)));
        return new ResponseEntity<>(outHeaders, HttpStatus.FOUND);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<String> getLinkMetrics(@PathVariable("id") Long inId) {
        Integer outRedirectCount = this.servicio.getRedirectCount(inId);
        return new ResponseEntity<String>(
                String.format("El link %d se ha redireccionado %d veces",
                        inId, outRedirectCount), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<String> invalidateLink(@PathVariable("id") Long inId) {
        if (this.servicio.invalidateLink(inId)) {
            return new ResponseEntity<String>("Link invalidado con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(
                    String.format("El link con id %d no ha podido invalidarse", inId),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
