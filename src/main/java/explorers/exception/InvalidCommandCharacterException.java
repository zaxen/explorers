package explorers.exception;

public class InvalidCommandCharacterException extends ExplorerException {

	private final char invalidCommand;
	
	public InvalidCommandCharacterException(char invalidCommand) {
		super("Invalid command character " + invalidCommand);
		this.invalidCommand = invalidCommand;
	}
	
	public char getInvalidCommand() {
		return invalidCommand;
	}
}
