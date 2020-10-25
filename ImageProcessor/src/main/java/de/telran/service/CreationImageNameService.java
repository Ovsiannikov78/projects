package de.telran.service;

import de.telran.entity.ActionableImage;

public class CreationImageNameService {

    public String getImageName(ActionableImage image) {
        return image.getSourceUrl().replaceAll("https://", "").replaceAll("/", ".");
    }
}