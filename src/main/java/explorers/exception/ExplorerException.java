package explorers.exception;

/**
 * Base class for custom Explorer Exceptions
 */
public abstract class ExplorerException extends RuntimeException {

	public ExplorerException() {
		super();
	}

	public ExplorerException(String message) {
		super(message);
	}

	public ExplorerException(Throwable cause) {
		super(cause);
	}

	public ExplorerException(String message, Throwable cause) {
		super(message, cause);
	}
}
