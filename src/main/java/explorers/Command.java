package explorers;

import java.util.ArrayList;
import java.util.List;

import explorers.exception.InvalidCommandCharacterException;

/**
 * A Command for an Explorer
 */
public enum Command {
	/** The rotate left command */
	ROTATE_LEFT('L') {
		void run(Explorer explorer) {
			explorer.direction = explorer.direction.rotateLeft();
		}
	},
	/** The rotate right command */
	ROTATE_RIGHT('R') {
		void run(Explorer explorer) {
			explorer.direction = explorer.direction.rotateRight();
		}
	},
	/** The move command */
	MOVE('M') {
		void run(Explorer explorer) {
			explorer.move();
		}
	};
	
	/**
	 * Get the Command that corresponds to the command character.  Valid characters are
	 * <dl>
	 *   <dt>L</dt><dd>Rotate Left command</dd>
	 *   <dt>R</dt><dd>Rotate Right command</dd>
	 *   <dt>M</dt><dd>Move command</dd>
	 * </dl>
	 * 
	 * @param commandChar The character to get the corresponding Command for
	 * @return The Command for the character
	 * @throws InvalidCommandCharacterException if the character isn't a valid Command
	 */
	public static Command valueOf(char commandChar) {
		for (Command command : values()) {
			if (command.command == commandChar) {
				return command;
			}
		}
		throw new InvalidCommandCharacterException(commandChar);
	}
	
	/**
	 * Get the Commands that corresponds to the command characters.
	 * 
	 * @param commandChars The sequence of command characters
	 * @return The list of Command corresponding to the CharSequence
	 */
	public static List<Command> valuesOf(CharSequence commandChars) {
		List<Command> retval = new ArrayList<>(commandChars.length());
		for (int i = 0; i < commandChars.length(); ++i) {
			retval.add(valueOf(commandChars.charAt(i)));
		}
		return retval;
	}
	
	private final char command;
	
	Command(char command) {
		this.command = command;
	}

	/**
	 * Gets the single character representation of this Command
	 * @return The single character representation
	 */
	public char getCommandCharacter() {
		return command;
	}
	
	/**
	 * Runs this command on the given explorer.
	 *
	 * @param explorer The Explorer to run this command on
	 */
	abstract void run(Explorer explorer);
}
