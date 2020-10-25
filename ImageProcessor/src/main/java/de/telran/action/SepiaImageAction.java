package de.telran.action;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SepiaImageAction implements ImageAction {
    @Override
    public String getName() {
        return "SEPIA";
    }

    @Override
    public BufferedImage doAction(BufferedImage source) {
        System.out.println("Creating a sepia");
        return doSepia(source);
    }

    public static BufferedImage doSepia(BufferedImage source) {

        BufferedImage sepiaImage = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

        for (int i = 0; i < source.getWidth(); i++) {
            for (int j = 0; j < source.getHeight(); j++) {
                {
                    int pic = source.getRGB(i, j);
                    int in_r = ((pic >> 16) & 0xFF);
                    int in_g = ((pic >> 8) & 0xFF);
                    int in_b = (pic & 0xFF);
                    float out_r = (float) (((in_r * .393) + (in_g * .769) + (in_b * .189)) / 256);
                    if (out_r > 1)
                        out_r = 1;
                    float out_g = (float) (((in_r * .349) + (in_g * .686) + (in_b * .168)) / 256);
                    if (out_g > 1)
                        out_g = 1;
                    float out_b = (float) (((in_r * .272) + (in_g * .534) + (in_b * .131)) / 256);
                    if (out_b > 1)
                        out_b = 1;
                    Color color = new Color(out_r, out_g, out_b);
                    int RGB = color.getRGB();
                    sepiaImage.setRGB(i, j, RGB);
                }
            }
        }

        return sepiaImage;
    }
}