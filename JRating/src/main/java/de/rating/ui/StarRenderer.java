package de.rating.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import de.rating.JRating;

public class StarRenderer implements RatingRenderer {

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
			imageFocusedMarked = ImageIO.read(load("de/rating/ui/star/mark-focus" + urlSize + ".png"));
			imageFocused = ImageIO.read(load("de/rating/ui/star/focus" + urlSize + ".png"));
			imageMarked = ImageIO.read(load("de/rating/ui/star/mark" + urlSize + ".png"));
			image = ImageIO.read(load("de/rating/ui/star/" + urlSize + ".png"));
		} catch (IOException e) {
		}
	}

	@Override
	public void paint(Graphics g, JRating c, int index, 
			boolean marked, boolean selected, boolean focused) {
		if(marked) {
			if(focused) {
				g.drawImage(imageFocusedMarked, 0, 0, null);
			} else {
				g.drawImage(imageMarked, 0, 0, null);
			}
		} else {
			if(focused) {
				g.drawImage(imageFocused, 0, 0, null);
			} else {
				g.drawImage(image, 0, 0, null);
			}
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
}
