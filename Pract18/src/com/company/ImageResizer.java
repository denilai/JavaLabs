package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

public class ImageResizer implements Runnable {

    private final String dstFolder;

    private final File[] files;

    private final int num;

    public ImageResizer(String dstFolder, File[] files, int num) {
        System.out.println(num+ "'s thread is created");

        this.dstFolder = dstFolder;
        this.files = files;
        this.num = num;

    }

    @Override
    public void run() {
        for(File file : files) {
            try {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }

                int newWidth = image.getWidth() / 2;
                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );
                BufferedImage newImage = new BufferedImage(
                        newWidth, newHeight, BufferedImage.TYPE_INT_RGB
                );

                int widthStep = image.getWidth() / newWidth;
                int heightStep = image.getHeight() / newHeight;

                for (int x = 0; x < newWidth; x++) {
                    for (int y = 0; y < newHeight; y++) {
                        int rgb = image.getRGB(x * widthStep, y * heightStep);
                        newImage.setRGB(x, y, rgb);
                    }
                }

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
