package de.ovsiannikov.urlshortenerbackend.controller;

import de.ovsiannikov.urlshortenerbackend.dto.StatisticDto;
import de.ovsiannikov.urlshortenerbackend.service.StatisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }


    @GetMapping("/statistics")
    public ResponseEntity<List<StatisticDto>> getStatisticOfTheShortUrl () {

        return new ResponseEntity<>(statisticsService.getTheMostFrequentlyUsedShortUrls(), HttpStatus.OK);
    }
}
