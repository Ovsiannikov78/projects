package de.ovsiannikov.urlshortenerbackend.service;

import de.ovsiannikov.urlshortenerbackend.dto.RedirectStatisticDto;
import lombok.Data;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.List;

@Data
@Service
public class KafkaListenerService {

    private final static String topic = "redirect-statistic";
    private final static String groupId = "statistic";

    private final StatisticsService statisticsService;


    @KafkaListener(topics = topic, groupId = groupId, containerFactory = "kafkaListenerContainerFactory")
    public void listen(List<RedirectStatisticDto> statisticDto) {

        statisticsService.createOrUpdateRedirectStatisticInDB(statisticDto);

        System.out.println("List of RedirectStatisticDto from KafkaConsumer -" + statisticDto.toString());
    }
}

