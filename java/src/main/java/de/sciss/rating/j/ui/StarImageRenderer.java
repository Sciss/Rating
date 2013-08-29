/*
 * StarImageRenderer.java
 * (Rating)
 *
 * Copyright (c) 2011 Hendrik Ebbers.
 * Copyright (c) 2013 Hanns Holger Rutz. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.sciss.rating.j.ui;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class StarImageRenderer extends AbstractImageRatingRenderer {

	private boolean largeSize;
	
	BufferedImage imageFocusedMarked;
	
	BufferedImage imageFocused;
	
	BufferedImage imageMarked;
	
	BufferedImage image;
	
	public StarImageRenderer() {
		this(false);
	}
	
	public StarImageRenderer(boolean large) {
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
