package de.rating.demo;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import de.rating.ui.AbstractImageRatingRenderer;

public class SmileyRenderer extends AbstractImageRatingRenderer {

	private BufferedImage imageFocusedMarked;
	
	private BufferedImage imageFocused;
	
	private BufferedImage imageMarked;
	
	private BufferedImage image;
	
	public SmileyRenderer() {
		try {
			imageFocusedMarked = ImageIO.read(load("/de/rating/demo/face-smile-focused.png"));
			imageFocused = ImageIO.read(load("/de/rating/demo/face-sad-focused.png"));
			imageMarked = ImageIO.read(load("/de/rating/demo/face-smile.png"));
			image = ImageIO.read(load("/de/rating/demo/face-sad.png"));
		} catch (IOException e) {
		}
	}
	
	public URL load(String path) throws IOException {
        URL url = ClassLoader.getSystemClassLoader().getResource(path);
        if (url == null) {
            // Fuer den Gebrauch mit Jars
            url = this.getClass().getResource(path);
        }
        if (url == null) {
            url = ClassLoader.getSystemResource(path);
        }
        if (url == null) {
            throw new IOException("URL für " + path + " konnte nicht erstellt werden!");
        }
        return url;
    }
	
	@Override
	public Dimension getMarkSize() {
		return new Dimension(64,64);
	}

	@Override
	public BufferedImage getFocusedAndMarkedImage() {
		return imageFocusedMarked;
	}

	@Override
	public BufferedImage getFocusedImage() {
		return imageFocused;
	}

	@Override
	public BufferedImage getMarkedImage() {
		return imageMarked;
	}

	@Override
	public BufferedImage getUnmarkedImage() {
		return image;
	}

}
