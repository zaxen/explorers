package explorers;

import java.util.Objects;

/**
 * The Bounds for an explorer
 */
public class Bounds {

	final int minX;
	final int minY;
	final int maxX;
	final int maxY;

	/**
	 * Create a Bounds with default bottom left corner of (0,0)
	 * 
	 * @param maxX
	 *            The right most coordinate
	 * @param maxY
	 *            The top most coordinate
	 */
	Bounds(int maxX, int maxY) {
		this.minX = 0;
		this.minY = 0;
		this.maxX = maxX;
		this.maxY = maxY;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public int getMinX() {
		return minX;
	}

	public int getMinY() {
		return minY;
	}
	
	/**
	 * Checks whether the given co-ordinates are within this bounds
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return true if the given coordinates are within this bounds, false otherwise
	 */
	public boolean check(int x, int y) {
		return x >= minX && x <= maxX && y >= minY && y <= maxY;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Bounds)) {
			return false;
		}
		Bounds b = (Bounds) obj;
		return Objects.equals(minX, b.minX) && Objects.equals(minY, b.minY)
				&& Objects.equals(maxX, b.maxX) && Objects.equals(maxY, b.maxY);
	}

	@Override
	public int hashCode() {
		return Objects.hash(minX, minY, maxX, maxY);
	}
}
