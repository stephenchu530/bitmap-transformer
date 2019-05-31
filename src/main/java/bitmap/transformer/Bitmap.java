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

    // Transform #1
    public void crazy() {
        int rgb;

        for (int h = 1; h < this.height; h++) {
            for (int w = 1; w < this.width; w++) {
                rgb = this.imageData.getRGB(w, h) / 2;
                this.imageData.setRGB(w, h, rgb);
            }
        }
    }

    // Transform #2
    public void light() {
        int rgb;

        for (int h = 1; h < this.height; h++) {
            for (int w = 1; w < this.width; w++) {
                rgb = (this.imageData.getRGB(w, h) * 2) % 256;
                this.imageData.setRGB(w, h, rgb);
            }
        }
    }

    // Transform #3
    public void invert() {
        int rgb;

        for (int h = 1; h < this.height; h++) {
            for (int w = 1; w < this.width; w++) {
                rgb = 255 - this.imageData.getRGB(w, h);
                this.imageData.setRGB(w, h, rgb);
            }
        }
    }

    // Transform #4
    public void vflip() {
        int src = 0;
        int dst = 0;

        for (int h = 1; h < this.height / 2; h++) {
            for (int w = 1; w < this.width; w++) {
                src = this.imageData.getRGB(w, h);
                dst = this.imageData.getRGB(w, this.height - h);
                this.imageData.setRGB(w, h, dst);
                this.imageData.setRGB(w, this.height - h, src);
            }
        }
    }

    // Transform #5
    public void hflip() {
        int src = 0;
        int dst = 0;

        for (int h = 1; h < this.height; h++) {
            for (int w = 1; w < this.width / 2; w++) {
                src = this.imageData.getRGB(w, h);
                dst = this.imageData.getRGB(this.width - w, h);
                this.imageData.setRGB(w, h, dst);
                this.imageData.setRGB(this.width - w, h, src);
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
