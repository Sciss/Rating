/*
 * AbstractImageRatingRenderer.java
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

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import de.sciss.rating.j.JRating;


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
