package de.ovsiannikov.urlshortenerbackend.service;

import de.ovsiannikov.urlshortenerbackend.dto.RedirectStatisticDto;
import de.ovsiannikov.urlshortenerbackend.dto.StatisticDto;

import java.util.List;


public interface StatisticsService {

   void createOrUpdateRedirectStatisticInDB(List<RedirectStatisticDto> redirectStatisticDtoList);

   List<StatisticDto> getTheMostFrequentlyUsedShortUrls();
}
