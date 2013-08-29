/*
 * RatingEvent.java
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

import java.util.EventObject;

public class RatingEvent extends EventObject {

	private static final long serialVersionUID = 1L;

	private final int markCount;
	private final int maxCount;
    // private final boolean adjusting;
	
	public RatingEvent(Object source, int markCount, int maxCount /*, boolean adjusting */) {
		super(source);
		this.markCount  = markCount;
		this.maxCount   = maxCount;
        // this.adjusting  = adjusting;
	}
	
	public int getMarkCount() {
		return markCount;
	}
	
	public int getMaxCount() {
		return maxCount;
	}

    // public boolean isAdjusting {
    //     return adjusting;
    // }
}
