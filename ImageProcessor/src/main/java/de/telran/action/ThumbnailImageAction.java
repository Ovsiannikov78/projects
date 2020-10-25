package de.telran.action;

import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;

public class ThumbnailImageAction implements ImageAction {
    @Override
    public String getName() {
        return "THUMBNAIL";
    }

    @Override
    public BufferedImage doAction(BufferedImage source) {
        System.out.println("Creating a thumbnail");
        return doThumbnail(source);
    }

    public static BufferedImage doThumbnail(BufferedImage source) {
        return Scalr.resize(source, Scalr.Method.QUALITY, 100, 100, Scalr.OP_ANTIALIAS);
    }
}