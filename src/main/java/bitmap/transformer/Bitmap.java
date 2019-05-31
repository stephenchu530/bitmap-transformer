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
    public Bitmap (String filePath) {
        this.imageData = read(filePath);
        this.height = this.imageData.getHeight();
        this.width = this.imageData.getWidth();
    }

    public void crazy() {
        int rgb;

        for (int h = 1; h < this.height; h++) {
            for (int w = 1; w < this.width; w++) {
                rgb = this.imageData.getRGB(w, h) / 2;
                this.imageData.setRGB(w, h, rgb);
            }
        }
    }

    public BufferedImage read(String filePath) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            System.out.println("Failed to open image");
            System.out.println(e);
        }
        return img;
    }

    public void save(String filePath) {
        try {
            ImageIO.write(this.imageData, "bmp", new File(filePath));
        } catch (IOException e) {
            System.out.println("ERROR SAVING!");
            System.out.println(e);
        }
    }
}
