package com.guigarage.jrating;

public interface RatingListener {

	public void indexChanged(RatingEvent event);
	
	public void maxCountChanged(RatingEvent event);
}
