package de.sciss.rating.j.ui;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class StarRenderer extends AbstractImageRatingRenderer {

	private boolean largeSize;
	
	BufferedImage imageFocusedMarked;
	
	BufferedImage imageFocused;
	
	BufferedImage imageMarked;
	
	BufferedImage image;
	
	public StarRenderer() {
		this(false);
	}
	
	public StarRenderer(boolean large) {
		setLargeSize(large);
	}
	
	public boolean isLargeSize() {
		return largeSize;
	}

	public void setLargeSize(boolean largeSize) {
		this.largeSize = largeSize;
		
		String urlSize = "16"; 
		if(largeSize) {
			urlSize = "32";
		}

		try {
			imageFocusedMarked = ImageIO.read(load("/de/sciss/rating/star/mark-focus" + urlSize + ".png"));
			imageFocused = ImageIO.read(load("/de/sciss/rating/star/focus" + urlSize + ".png"));
			imageMarked = ImageIO.read(load("/de/sciss/rating/star/mark" + urlSize + ".png"));
			image = ImageIO.read(load("/de/sciss/rating/star/" + urlSize + ".png"));
		} catch (IOException e) {
		}
	}

	@Override
	public Dimension getMarkSize() {
		if(largeSize) {
			return new Dimension(32, 32);
		}
		return new Dimension(16, 16);
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