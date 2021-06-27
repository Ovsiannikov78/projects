package de.ovsiannikov.urlshortenerbackend.service;

import java.util.Optional;

public interface RedirectService {

    Optional<String> getRedirectUrl(String shortUrl);
}
