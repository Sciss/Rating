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
