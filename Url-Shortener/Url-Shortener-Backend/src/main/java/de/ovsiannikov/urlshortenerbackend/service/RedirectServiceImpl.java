package de.ovsiannikov.urlshortenerbackend.service;

import de.ovsiannikov.urlshortenerbackend.dao.UrlRepository;
import de.ovsiannikov.urlshortenerbackend.dto.RedirectStatisticDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RedirectServiceImpl implements RedirectService {

    private final UrlRepository urlRepository;
    private final KafkaProducerService producerService;

    public RedirectServiceImpl(UrlRepository urlRepository, KafkaProducerService producerService) {
        this.urlRepository = urlRepository;
        this.producerService = producerService;
    }

    @Override
    public Optional<String> getRedirectUrl(String shortUrl) {

        LocalDateTime expirationDate = urlRepository.findByShortUrl(shortUrl).getExpirationDate();
        LocalDateTime currentDate = LocalDateTime.now();

        if (!shortUrl.isBlank() && currentDate.isBefore(expirationDate)) {

            producerService.produce(createRedirectStatisticDto(shortUrl));

            return Optional.ofNullable(urlRepository.findByShortUrl(shortUrl).getLongUrl());
        }
        return Optional.empty();
    }


    private RedirectStatisticDto createRedirectStatisticDto (String shortUrl){

        return new RedirectStatisticDto(shortUrl,urlRepository.findByShortUrl(shortUrl).getLongUrl(),LocalDateTime.now());
    }
}

