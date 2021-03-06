/*
 * RenderBasedRatingUI.java
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
import java.awt.Graphics;
import java.awt.Rectangle;

import de.sciss.rating.j.JRating;


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
