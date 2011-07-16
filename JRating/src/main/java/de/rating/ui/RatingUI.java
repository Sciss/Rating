package de.rating.ui;

import java.awt.Point;

import javax.swing.plaf.ComponentUI;

public abstract class RatingUI extends ComponentUI {

	public abstract int getIndexAt(Point p);

}
