package de.telran;

import de.telran.entity.ActionableImage;
import de.telran.entity.ImageDescriptor;
import de.telran.factory.ImageActionFactory;
import de.telran.service.*;

import java.util.List;
import java.util.stream.Collectors;


public class ImageProcessor {
    private ConfigService configService;
    private ImageDescriptorService imageDescriptorService;
    private DownloadService downloadService;
    private ImageService imageService;
    private ImageFileService imageFileService;
    private CsvFileService csvFileService;


    public ImageProcessor(ImageDescriptorService imageDescriptorService,
                          DownloadService downloadService,
                          ImageService imageService,
                          ImageFileService imageFileService, CsvFileService csvFileService,
                          ConfigService configService) {
        this.imageDescriptorService = imageDescriptorService;
        this.downloadService = downloadService;
        this.imageService = imageService;
        this.imageFileService = imageFileService;
        this.csvFileService = csvFileService;
        this.configService = configService;
    }

    public void doProcessing(String fileName) {

        List<ImageDescriptor> imageDescriptors = imageDescriptorService.getImageDescriptors(fileName);

        List<ActionableImage> actionableImages = imageDescriptors
                .stream()
                .map(i -> new ActionableImage(null, false, i.getImageUrlName(), i.getActionName()))
                .collect(Collectors.toList());

        List<ActionableImage> downloadedImages = downloadService.downloadImages(actionableImages);

        List<ActionableImage> successfullyDownloadedImages = downloadedImages.stream()
                .filter(ActionableImage::isSuccessful)
                .collect(Collectors.toList());

        List<ActionableImage> processedImages = successfullyDownloadedImages
                .stream()
                .map(i -> imageService.processImage(i))
                .collect(Collectors.toList());

        processedImages.forEach(i -> imageFileService.saveImageAsFile(i));

    }

    public static void main(String[] args) throws Exception {

        String fileName = args[0];

        ConfigService configService = new ConfigService();
        ImageFileService imageFileService = new ImageFileService(configService);
        CsvFileService csvFileService = new CsvFileService();

        ImageDescriptorService imageDescriptorService = new ImageDescriptorService(csvFileService, configService);

        DownloadService downloadService = new DownloadService();

        ImageService imageService = new ImageService(new ImageActionFactory(new ActionsConfigService()));

        ImageProcessor processor = new ImageProcessor(imageDescriptorService, downloadService, imageService, imageFileService, csvFileService,
                configService);

        processor.doProcessing(fileName);
    }
}
