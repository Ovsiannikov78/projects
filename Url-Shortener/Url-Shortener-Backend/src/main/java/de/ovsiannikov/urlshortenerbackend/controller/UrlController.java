package de.ovsiannikov.urlshortenerbackend.controller;

import de.ovsiannikov.urlshortenerbackend.dto.LongUrlDto;
import de.ovsiannikov.urlshortenerbackend.dto.ShortUrlDto;
import de.ovsiannikov.urlshortenerbackend.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/urls")
    public ResponseEntity<ShortUrlDto> createShortUrlDto(@Valid @RequestBody LongUrlDto longUrlDto) {

        return new ResponseEntity<>(urlService.createShortUrlDto(longUrlDto), HttpStatus.OK);
    }

    @DeleteMapping("/urls/{id}")
    public String deleteUrl(@PathVariable Long id) {
        urlService.deleteUrl(id);

        return "Url with id " + id + " was deleted.";
    }
}
