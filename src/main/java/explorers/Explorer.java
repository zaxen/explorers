package explorers;

import java.util.List;
import java.util.Objects;

import explorers.exception.InvalidCommandCharacterException;
import explorers.exception.InvalidPositionException;

/**
 * An Explorer
 */
public class Explorer {
	/** The bounds for this explorer */
	private final Bounds bounds;

	/** Current x co-ordinate */
	int x;
	/** Current y co-ordinate */
	int y;
	/** Current heading */
	Direction direction;

	/**
	 * Create a new explorer
	 * 
	 * @param bounds
	 *            The bounds for the explorer
	 * @param x
	 *            The explorer's initial x co-ordinate
	 * @param y
	 *            The explorer's initial y co-ordinate
	 * @param direction
	 *            The explorer's initial direction
	 */
	public Explorer(Bounds bounds, int x, int y, Direction direction) {
		this.bounds = bounds;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	/**
	 * Retrieves the explorer's current x co-ordinate
	 * 
	 * @return The x co-ordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Retrieves the explorer's current y co-ordinate
	 * 
	 * @return The y co-ordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Retrieves the direction the explorer is currently facing
	 * 
	 * @return The direction the explorer is currently facing
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Runs a sequence of {@link Command}s, each command encoded as a character
	 * 
	 * @param moves
	 *            The sequence of commands
	 * @see Explorer#run(List<Command>)
	 * @see Command#valuesOf(CharSequence)
	 * @throws InvalidCommandCharacterException
	 *             if one of the characters isn't a valid Command
	 * @throws InvalidPositionException
	 *             if the Explorer moves out of bounds
	 */
	public void run(CharSequence moves) {
		for (int i = 0; i < moves.length(); ++i) {
			run(moves.charAt(i));
		}
	}

	/**
	 * Runs a single command, the command encoded as a character
	 * 
	 * @param move
	 *            The move, encoded as a character
	 * @see Explorer#run(Command)
	 * @see Command#valueOf(char)
	 * @throws InvalidCommandCharacterException
	 *             if the character isn't a valid Command
	 * @throws InvalidPositionException
	 *             if the Explorer moves out of bounds
	 */
	public void run(char move) {
		run(Command.valueOf(move));
	}

	/**
	 * Runs a list of {@link Command}s
	 * 
	 * @param commands
	 *            The list of commands to run
	 * @throws InvalidPositionException
	 *             if the Explorer moves out of bounds
	 */
	public void run(List<Command> commands) {
		for (Command command : commands) {
			run(command);
		}
	}

	/**
	 * Run a single {@link Command}
	 * 
	 * @param command
	 *            The command to run
	 * @throws InvalidPositionException
	 *             if the Explorer moves out of bounds
	 */
	public void run(Command command) {
		command.run(this);
	}

	/**
	 * Move the Explorer in the direction it's currently facing
	 * 
	 * @throws InvalidPositionException
	 *             if the move takes the Explorer out of bounds
	 */
	void move() {
		final int x = this.x + direction.dx;
		final int y = this.y + direction.dy;

		if (!bounds.check(x,y)) {
			throw new InvalidPositionException(x, y, bounds);
		}

		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Explorer)) {
			return false;
		}
		Explorer e = (Explorer) obj;
		return Objects.equals(direction, e.direction) && Objects.equals(x, e.x)
				&& Objects.equals(y, e.y) && Objects.equals(bounds, e.bounds);
	}

	@Override
	public int hashCode() {
		return Objects.hash(direction, x, y, bounds);
	}

	@Override
	public String toString() {
		return x + " " + y + " " + direction.name();
	}
}
