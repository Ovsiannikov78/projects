package de.telran.service;

import de.telran.entity.ActionableImage;

import javax.imageio.ImageIO;
import java.io.File;

public class ImageFileService {

    private ConfigService configService;
    private CreationImageNameService creationImageNameService = new CreationImageNameService();

    public ImageFileService(ConfigService configService) {
        this.configService = configService;
    }

    public void saveImageAsFile(ActionableImage image) {
        try {
            ImageIO.write(image.getImage(), "jpg", new File(configService.getPathToSavedImages()
                    + creationImageNameService.getImageName(image)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
