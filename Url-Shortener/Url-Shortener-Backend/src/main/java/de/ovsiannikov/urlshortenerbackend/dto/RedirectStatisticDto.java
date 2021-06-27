package de.ovsiannikov.urlshortenerbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "currentDate")
public class RedirectStatisticDto {

    private String shortUrl;

    private String longUrl;

    private LocalDateTime currentDate;
}
