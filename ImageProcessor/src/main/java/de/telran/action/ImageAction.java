package de.telran.action;

import java.awt.image.BufferedImage;

public interface ImageAction {
    String getName();

    BufferedImage doAction(BufferedImage source) throws Exception;
}