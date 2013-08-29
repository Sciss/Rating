package com.guigarage.jrating.ui;

import java.awt.Dimension;
import java.awt.Graphics;

import com.guigarage.jrating.JRating;


public interface RatingRenderer {

	void paint(Graphics g, JRating c, int index,
			boolean marked, boolean selected, boolean focused);

	Dimension getMarkSize();

}
