package de.rating;

public interface RatingListener {

	public void indexChanged(RatingEvent event);
	
	public void maxCountChanged(RatingEvent event);
}
