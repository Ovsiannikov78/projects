package de.telran.action;

import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;

public class PreviewImageAction implements ImageAction {
    @Override
    public String getName() {
        return "PREVIEW";
    }

    @Override
    public BufferedImage doAction(BufferedImage source) {
        System.out.println("Creating a preview");
        return doPreview(source);
    }

    public static BufferedImage doPreview(BufferedImage source) {
        return Scalr.resize(source, Scalr.Method.QUALITY, 250, 250, Scalr.OP_ANTIALIAS);
    }
}
