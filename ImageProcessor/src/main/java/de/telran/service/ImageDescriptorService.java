package de.telran.service;

import de.telran.entity.ImageDescriptor;

import java.util.List;
import java.util.stream.Collectors;

public class ImageDescriptorService {

    private ConfigService configService;
    private CsvFileService csvFileService;

    public ImageDescriptorService(CsvFileService csvFileService, ConfigService configService) {
        this.csvFileService = csvFileService;
        this.configService = configService;
    }

    public List<ImageDescriptor> getImageDescriptors(String fileName) {
        return csvFileService.loadStringsFromFile(fileName).stream()
                .map(s -> stringToImageDescriptor(s))
                .collect(Collectors.toList());
    }

    private ImageDescriptor stringToImageDescriptor(String string) {
        String[] split = string.split(configService.getPathSeparator());
        return new ImageDescriptor(split[0].trim(), split[1].trim());
    }
}