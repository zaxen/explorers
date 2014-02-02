package explorers;

import java.util.Objects;

/**
 * Holds the result of a Simulation
 */
public class SimulationResult {

	public static SimulationResult success(Explorer explorer) {
		return new SimulationResult(explorer);
	}
	
	public static SimulationResult error(Explorer explorer, Exception exception) {
		return new SimulationResult(explorer, exception);
	}
	
	private final Explorer explorer;
	private final Exception exception;
	
	public SimulationResult(Explorer explorer) {
		this(explorer,null);
	}

	public SimulationResult(Explorer explorer, Exception exception) {
		this.explorer = explorer;
		this.exception = exception;
	}
	
	public Exception getException() {
		return exception;
	}
	
	public Explorer getLocation() {
		return explorer;
	}
	
	public boolean isErrorResult() {
		return exception != null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SimulationResult)) {
			return false;
		}
		SimulationResult sr = (SimulationResult) obj;
		return Objects.equals(explorer, sr.explorer) && Objects.equals(exception, sr.exception);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(exception, explorer);
	}
	
	@Override
	public String toString() {
		if (isErrorResult())
			return exception.getMessage();
		else
			return explorer.toString();
	}
}
