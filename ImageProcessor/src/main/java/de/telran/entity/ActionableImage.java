package de.telran.entity;

import java.awt.image.BufferedImage;

public class ActionableImage {
    private BufferedImage image;
    private boolean isSuccessful;
    private String sourceUrl;
    private String actionName;

    public ActionableImage(BufferedImage image, boolean status, String sourceUrl, String actionName) {
        this.image = image;
        this.isSuccessful = status;
        this.sourceUrl = sourceUrl;
        this.actionName = actionName;

    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getActionName() {
        return actionName;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}