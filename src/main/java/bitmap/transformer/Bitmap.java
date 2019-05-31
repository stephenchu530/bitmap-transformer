package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {
    // Source code taken from SO:
    // https://stackoverflow.com/questions/16475482/how-can-i-load-a-bitmap-image-and-manipulate-individual-pixels

    int height;
    int width;
    BufferedImage imageData;

    // Constructor
    public Bitmap (BufferedImage img) {
        this.height = img.getHeight();
        this.width = img.getWidth();
        this.imageData = img;
    }

    public void darken() {
        int rgb;

        for (int h = 1; h < this.height; h++) {
            for (int w = 1; w < this.width; w++) {
                rgb = this.imageData.getRGB(w, h) / 2;
                this.imageData.setRGB(w, h, rgb);
            }
        }
    }

    public BufferedImage getImageData() {
        return this.imageData;
    }
}
