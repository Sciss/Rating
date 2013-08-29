/*
 * DefaultRatingModel.java
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

import java.util.ArrayList;
import java.util.List;

public class DefaultRatingModel implements RatingModel {

	private int maxCount;
	private int markCount;
	
	private List<RatingListener> listeners;
	
    public DefaultRatingModel() {
        this(5);
    }

    public DefaultRatingModel(int maxCount) {
           this(maxCount, 0);
    }

	public DefaultRatingModel(int maxCount, int markCount) {
        this.maxCount   = maxCount;
        this.markCount  = markCount;
		listeners       = new ArrayList<RatingListener>();
	}
	
	@Override
	public int getMarkCount() {
		return markCount;
	}

	@Override
	public int getMaxCount() {
		return maxCount;
	}

	@Override
	public void setMarkCount(int markCount) {
        if (this.markCount != markCount) {
            if (markCount < 0 || markCount > maxCount) throw new IllegalArgumentException(String.valueOf(markCount));
            this.markCount = markCount;
            fireIndexChanged();
        }
	}

	@Override
	public void setMaxCount(int maxCount) {
        if (this.maxCount != maxCount) {
            if (maxCount < 1) throw new IllegalArgumentException(String.valueOf(maxCount));
            this.maxCount = maxCount;
            fireMaxCountChanged();
        }
	}

	private void fireIndexChanged() {
		RatingEvent event = null;
		for (RatingListener listener : listeners) {
			if(event == null) {
				event = new RatingEvent(this, getMarkCount(), getMaxCount());
			}
			listener.indexChanged(event);
		}
	}
	
	private void fireMaxCountChanged() {
		RatingEvent event = null;
		for (RatingListener listener : listeners) {
			if(event == null) {
				event = new RatingEvent(this, getMarkCount(), getMaxCount());
			}
			listener.maxCountChanged(event);
		}
	}

	@Override
	public void addRateListener(RatingListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeRateListener(RatingListener listener) {
		listeners.remove(listener);
	}

}
