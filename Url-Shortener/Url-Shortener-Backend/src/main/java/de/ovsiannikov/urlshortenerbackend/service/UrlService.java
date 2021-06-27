package de.ovsiannikov.urlshortenerbackend.service;

import de.ovsiannikov.urlshortenerbackend.dto.LongUrlDto;
import de.ovsiannikov.urlshortenerbackend.dto.ShortUrlDto;
import de.ovsiannikov.urlshortenerbackend.entity.Url;

import java.util.List;


public interface UrlService {

     List<Url> getAllUrls();

     Url createUrl(LongUrlDto longUrlDto);

     Url getUrl(Long id);

     void deleteUrl(Long id);

     ShortUrlDto createShortUrlDto(LongUrlDto longUrlDto);

}
