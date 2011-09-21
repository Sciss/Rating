package com.guigarage.jrating;

import java.util.EventObject;

public class RatingEvent extends EventObject {

	private static final long serialVersionUID = 1L;

	private  int markCount;
	
	private int maxCount;
	
	public RatingEvent(Object source, int markCount, int maxCount) {
		super(source);
		this.markCount = markCount;
		this.maxCount = maxCount;
	}
	
	public int getMarkCount() {
		return markCount;
	}
	
	public int getMaxCount() {
		return maxCount;
	}
}
