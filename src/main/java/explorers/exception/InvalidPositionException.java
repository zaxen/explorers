package explorers.exception;

import explorers.Bounds;

/**
 * Exception that indicates that an Explorer went out of bounds.
 */
public class InvalidPositionException extends ExplorerException {

	private final int x;
	private final int y;
	private final Bounds bounds;

	public InvalidPositionException(int x, int y, Bounds bounds) {
		super("Position (" + x + ", " + y + ") is outside simulation bounds ("
				+ bounds.getMaxX() + ", " + bounds.getMaxY() + ")");
		this.x = x;
		this.y = y;
		this.bounds = bounds;
	}
	
	/**
	 * @return the x co-ordinate of the Explorer when it went out of bounds.
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y co-ordinate of the Explorer when it went out of bounds.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @return the bounds the explorer was working within.
	 */
	public Bounds getBounds() {
		return bounds;
	}
}
