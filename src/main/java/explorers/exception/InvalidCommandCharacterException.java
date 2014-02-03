package explorers.exception;

/**
 * Exception that indicates an invalid command was issued to the explorer
 */
public class InvalidCommandCharacterException extends ExplorerException {

	private final char invalidCommand;
	
	public InvalidCommandCharacterException(char invalidCommand) {
		super("Invalid command character " + invalidCommand);
		this.invalidCommand = invalidCommand;
	}

	/**
	 * @return the invalid command character that was issued to the explorer.
	 */
	public char getInvalidCommand() {
		return invalidCommand;
	}
}
