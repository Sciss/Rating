package de.sciss.rating.j;

public interface RatingModel {

	int getMarkCount();
	
	int getMaxCount();
	
	void setMarkCount(int markCount);
	
	void setMaxCount(int maxCount);
	
	void addRateListener(RatingListener listener);
	
	void removeRateListener(RatingListener listener);
}
