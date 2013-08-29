package de.sciss.rating.j.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import de.sciss.rating.j.JRating;
import de.sciss.rating.j.RatingAlignment;


public class BasicRatingUI extends RatingUI {

	private JRating rateComponent;

	private Insets paintInsets;

	private RateKeyHandler rateKeyHandler;

	private RateMouseHandler rateMouseHandler;

	private FocusListener rateFocusAdapter;

	private class RateKeyHandler extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT
					|| e.getKeyCode() == KeyEvent.VK_DOWN
					|| e.getKeyCode() == KeyEvent.VK_MINUS) {
				rateComponent.setMarkCount(Math.max(0,
						rateComponent.getMarkedCount() - 1));
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT
					|| e.getKeyCode() == KeyEvent.VK_UP
					|| e.getKeyCode() == KeyEvent.VK_PLUS) {
				rateComponent.setMarkCount(Math.min(
						rateComponent.getMaxCount(),
						rateComponent.getMarkedCount() + 1));
			}
		}
	}

	private class RateMouseHandler extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			rateComponent.requestFocus();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			int index = getIndexAt(e.getPoint());
			if (index >= 0) {
				rateComponent.setMarkCount(Math.max(0, index + 1));
			} else {
				rateComponent.setMarkCount(0);
			}
		}
	}

	@Override
	public void installUI(JComponent c) {
		if (c instanceof JRating) {
			super.installUI(c);
			rateComponent = (JRating) c;
			rateComponent.setForeground(Color.yellow);
			paintInsets = new Insets(2, 2, 2, 2);
			rateKeyHandler = new RateKeyHandler();
			rateComponent.addKeyListener(rateKeyHandler);
			rateMouseHandler = new RateMouseHandler();
			rateComponent.addMouseListener(rateMouseHandler);
			rateFocusAdapter = new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent arg0) {
					rateComponent.repaint();
				}
				
				@Override
				public void focusGained(FocusEvent arg0) {
					rateComponent.repaint();
				}
			};
			rateComponent.addFocusListener(rateFocusAdapter);
		} else {
			throw new IllegalArgumentException("Only JRate allowed");
		}
	}

	@Override
	public void uninstallUI(JComponent c) {
		if (c instanceof JRating) {
			rateComponent.removeKeyListener(rateKeyHandler);
			rateKeyHandler = null;
			rateComponent.removeMouseListener(rateMouseHandler);
			rateMouseHandler = null;
			rateComponent.removeFocusListener(rateFocusAdapter);
			rateFocusAdapter = null;
			super.uninstallUI(c);
			rateComponent = null;
		} else {
			throw new IllegalArgumentException("Only JRate allowed");
		}
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
		Dimension dim = getMarkSize();
		int x = paintInsets.left;
		int y = paintInsets.top;
		for (int i = 0; i < rateComponent.getMaxCount(); i++) {
			Rectangle rect = new Rectangle();
			rect.x = x;
			rect.y = y;
			rect.width = dim.width;
			rect.height = dim.height;

			boolean marked = (i < rateComponent.getMarkedCount());
			boolean selected = (i == rateComponent.getMarkedCount() - 1);

			paintMark(g, (JRating) c, i, rect, marked, selected,
					rateComponent.isFocusOwner());

			if (rateComponent.getAlignment().equals(RatingAlignment.HORIZONTAL)) {
				x = x + rateComponent.getGap() + dim.width;
			} else {
				y = y + rateComponent.getGap() + dim.height;
			}
		}
	}

	protected void paintMark(Graphics g, JRating c, int index,
			Rectangle rect, boolean marked, boolean selected, boolean focused) {
		g.setColor(Color.black);
		if (marked) {
			g.setColor(rateComponent.getForeground());
		}
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
		
		if (focused) {
			g.setColor(Color.WHITE);
			g.drawRect(rect.x, rect.y, rect.width, rect.height);
		}
		if(selected) {
			g.setColor(Color.GRAY);
			g.drawRect(rect.x, rect.y, rect.width, rect.height);
		}
	}

	protected Dimension getMarkSize() {
		return new Dimension(16, 16);
	}

	@Override
	public int getIndexAt(Point p) {
		Dimension dim = getMarkSize();
		int x = paintInsets.left;
		int y = paintInsets.top;
		for (int i = 0; i < rateComponent.getMaxCount(); i++) {
			Rectangle rect = new Rectangle();
			rect.x = x;
			rect.y = y;
			rect.width = dim.width;
			rect.height = dim.height;

			if (rect.contains(p)) {
				return i;
			}

			if (rateComponent.getAlignment().equals(RatingAlignment.HORIZONTAL)) {
				x = x + rateComponent.getGap() + dim.width;
			} else {
				y = y + rateComponent.getGap() + dim.height;
			}
		}
		return -1;
	}

	@Override
	public Dimension getPreferredSize(JComponent c) {
		Dimension dim = getMarkSize();
		int x = paintInsets.left;
		int y = paintInsets.top;
		for (int i = 0; i < rateComponent.getMaxCount(); i++) {
			if (i + 1 < rateComponent.getMaxCount()) {
				if (rateComponent.getAlignment().equals(
						RatingAlignment.HORIZONTAL)) {
					x = x + rateComponent.getGap() + dim.width;
				} else {
					y = y + rateComponent.getGap() + dim.height;
				}
			}
		}
		return new Dimension(x + dim.width + paintInsets.right, y + dim.height
				+ paintInsets.bottom);
	}
}
