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

}
