package explorers.exception;

import explorers.Bounds;

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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Bounds getBounds() {
		return bounds;
	}
}
