package com.guigarage.jrating.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.guigarage.jrating.JRating;


public abstract class AbstractImageRatingRenderer implements RatingRenderer {

	public abstract BufferedImage getFocusedAndMarkedImage();
	
	public abstract BufferedImage getFocusedImage();
	
	public abstract BufferedImage getMarkedImage();
	
	public abstract BufferedImage getUnmarkedImage();
	
	@Override
	public void paint(Graphics g, JRating c, int index, 
			boolean marked, boolean selected, boolean focused) {
		if(marked) {
			if(focused) {
				g.drawImage(getFocusedAndMarkedImage(), 0, 0, null);
			} else {
				g.drawImage(getMarkedImage(), 0, 0, null);
			}
		} else {
			if(focused) {
				g.drawImage(getFocusedImage(), 0, 0, null);
			} else {
				g.drawImage(getUnmarkedImage(), 0, 0, null);
			}
		}
		
	}
}
