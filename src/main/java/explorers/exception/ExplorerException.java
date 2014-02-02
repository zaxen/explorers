package explorers.exception;


public class ExplorerException extends RuntimeException {

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
