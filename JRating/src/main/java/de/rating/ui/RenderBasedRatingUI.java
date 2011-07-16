package de.rating.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import de.rating.JRating;

public class RenderBasedRatingUI extends BasicRatingUI {

	private RatingRenderer renderer;
	
	public RenderBasedRatingUI(RatingRenderer renderer) {
		this.renderer = renderer;
	}
	
	@Override
	protected void paintMark(Graphics g, JRating c, int index,
			Rectangle rect, boolean marked, boolean selected, boolean focused) {
		renderer.paint(g.create(rect.x, rect.y, rect.width, rect.height), c, index, marked, selected, focused);
	}
	
	@Override
	protected Dimension getMarkSize() {
		return renderer.getMarkSize();
	}
}
