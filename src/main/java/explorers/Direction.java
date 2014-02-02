package explorers;

/**
 * Enum for all valid directions that an explorer can be facing
 */
public enum Direction {
	/** North */
	N(0, 1),
	/** East */
	E(1, 0),
	/** South */
	S(0, -1),
	/** West */
	W(-1, 0);

	/** The amount of x to move for this direction */
	final int dx;
	/** The amount of y to move for this direction */
	final int dy;

	Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	/**
	 * Get the direction that is one left rotation from this Direction
	 * 
	 * @return The Direction that is one rotation to the left
	 */
	public Direction rotateLeft() {
		return Direction.values()[pmod(this.ordinal() - 1,
				Direction.values().length)];
	}

	/**
	 * Get the direction that is one right rotation from this Direction
	 * 
	 * @return The Direction that is one rotation to the right
	 */
	public Direction rotateRight() {
		return Direction.values()[(this.ordinal() + 1)
				% Direction.values().length];
	}

	/**
	 * Positive modulo
	 * 
	 * @param dividend
	 *            The dividend
	 * @param divisor
	 *            The divisor
	 * @return The positive modulo of dividend and divisor
	 */
	private static int pmod(int dividend, int divisor) {
		int m = dividend % divisor;
		return m < 0 ? m + divisor : m;
	}
}
