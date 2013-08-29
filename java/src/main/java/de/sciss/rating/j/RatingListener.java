package de.sciss.rating.j;

public interface RatingListener {

	public void indexChanged(RatingEvent event);
	
	public void maxCountChanged(RatingEvent event);
}
