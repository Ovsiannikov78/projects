package de.ovsiannikov.urlshortenerbackend.service;

import de.ovsiannikov.urlshortenerbackend.dao.UrlRepository;
import de.ovsiannikov.urlshortenerbackend.dto.LongUrlDto;
import de.ovsiannikov.urlshortenerbackend.dto.ShortUrlDto;
import de.ovsiannikov.urlshortenerbackend.entity.Url;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UrlServiceImpl implements UrlService {

    private final HelperService helperService;
    private final UrlRepository urlRepository;

    public UrlServiceImpl(HelperService helperService, UrlRepository urlRepository) {
        this.helperService = helperService;
        this.urlRepository = urlRepository;
    }

    @Override
    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }

    @Override
    public Url createUrl(LongUrlDto longUrlDto) {

        Url url = new Url(helperService.generateShortUrl(), longUrlDto.getLongUrl(), 0,
                helperService.createUrlExpirationDate(longUrlDto.getExpirationDate()));
        return urlRepository.save(url);
    }

    @Override
    public ShortUrlDto createShortUrlDto(LongUrlDto longUrlDto) {
        Url url = createUrl(longUrlDto);
        return new ShortUrlDto(url.getId(), url.getShortUrl());

    }

    @Override
    public Url getUrl(Long id) {

        return urlRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteUrl(Long id) {
        urlRepository.deleteById(id);
    }
}
