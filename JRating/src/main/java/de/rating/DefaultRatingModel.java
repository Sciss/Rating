package de.rating;

import java.util.ArrayList;
import java.util.List;

public class DefaultRatingModel implements RatingModel {

	private int maxCount = 5;
	
	private int markCount = 0;
	
	private List<RatingListener> listeners;
	
	public DefaultRatingModel() {
		listeners = new ArrayList<RatingListener>();
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
		this.markCount = markCount;
		fireIndexChanged();
	}

	@Override
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
		fireMaxCountChanged();
	}

	private void fireIndexChanged() {
		for (RatingListener listener : listeners) {
			listener.indexChanged();
		}
	}
	
	private void fireMaxCountChanged() {
		for (RatingListener listener : listeners) {
			listener.maxCountChanged();
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
