package de.sciss.rating.j.ui;

import java.awt.Dimension;
import java.awt.Graphics;

import de.sciss.rating.j.JRating;


public interface RatingRenderer {

	void paint(Graphics g, JRating c, int index,
			boolean marked, boolean selected, boolean focused);

	Dimension getMarkSize();

}
