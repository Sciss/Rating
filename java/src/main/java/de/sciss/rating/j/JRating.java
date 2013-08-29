/*
 * JRating.java
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

package de.sciss.rating.j;

import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

import de.sciss.rating.j.ui.RatingUI;
import de.sciss.rating.j.ui.RenderBasedRatingUI;
import de.sciss.rating.j.ui.StarRenderer;


public class JRating extends JComponent implements RatingListener {

	private static final long serialVersionUID = 1L;

	private int gap;
	
	private RatingModel model;
	
	private RatingAlignment alignment;
	
	private RatingUI ui;
	
    public JRating() {
           this(new DefaultRatingModel());
       }

	public JRating(RatingModel model) {
        this(model, RatingAlignment.HORIZONTAL);
    }

    public JRating(RatingAlignment alignment) {
           this(new DefaultRatingModel(), alignment);
       }

    public JRating(RatingModel model, RatingAlignment alignment) {
		setModel(model);
		setAlignment(alignment);
		setGap(2);
		setUI(new RenderBasedRatingUI(new StarRenderer()));
		// setUI(new BasicRatingUI());
		setFocusable(true);
	}
	
	public boolean isMarked(int index) {
		return (index < getMarkedCount());
	}
	
	public int getIndexAt(Point p) {
		return ui.getIndexAt(p);
	}
	
	public int getIndexAt(int x, int y) {
		return getIndexAt(new Point(x, y));
	}
	
	public int getMarkedCount() {
		return getModel().getMarkCount();
	}
	
	public void setMarkCount(int index) {
		getModel().setMarkCount(index);
	}

	public int getMaxCount() {
		return getModel().getMaxCount();
	}
	
	public void setMaxCount(int count) {
		getModel().setMaxCount(count);
	}
		
	@Override
	public void setUI(ComponentUI newUI) {
		if(newUI instanceof RatingUI) {
			setUI((RatingUI)newUI);
		} else {
			throw new IllegalArgumentException("Only RateUI allowed");
		}
	}
	
	protected void setUI(RatingUI newUI) {
		super.setUI(newUI);
	}
	
	public void setAlignment(RatingAlignment alignment) {
		RatingAlignment oldAlignment = this.alignment;
		this.alignment = alignment;
		firePropertyChange("alignment", oldAlignment, this.alignment);
	}
	
	public RatingAlignment getAlignment() {
		return alignment;
	}
	
	public void setModel(RatingModel model) {
		if(model == null) {
			throw new NullPointerException("model==null");
		}
		if(this.model != null) {
			this.model.removeRateListener(this);
		}
		RatingModel oldModel = this.model;
		this.model = model;
		this.model.addRateListener(this);
		firePropertyChange("model", oldModel, this.model);
	}
	
	public RatingModel getModel() {
		return model;
	}
	
	public void setGap(int gap) {
		int oldGap = this.gap;
		this.gap = gap;
		firePropertyChange("gap", oldGap, this.gap);
	}
	
	public int getGap() {
		return this.gap;
	}

	@Override
	public void indexChanged(RatingEvent event) {
		repaint();
	}

	@Override
	public void maxCountChanged(RatingEvent event) {
		repaint();
	}
}
