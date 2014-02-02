package explorers;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SimulationIT {

	@Test
	public void testExamples() {
		String input =
"5 5\n" +
"1 2 N\n" +
"LMLMLMLMM\n" +
"3 3 E\n" +
"MMRMMRMRRM\n";
		List<String> output = Arrays.asList("1 3 N", "5 1 E");
		checkResults(input, output);
	}
	
	@Test
	public void testOutOfBounds() {
		String input =
"5 5\n" +
"1 2 N\n" +
"MMMMM\n" +
"1 2 S\n" +
"MMM\n" +
"1 2 E\n" +
"MMMMM\n" +
"1 2 W\n" +
"MM\n";
		List<String> output = Arrays.asList("Position (1, 6) is outside simulation bounds (5, 5)",
"Position (1, -1) is outside simulation bounds (5, 5)",
"Position (6, 2) is outside simulation bounds (5, 5)",
"Position (-1, 2) is outside simulation bounds (5, 5)");
		
		checkResults(input, output);
	}

	private void checkResults(String input, List<String> output) {
		ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
		
		Simulation simulation = new Simulation();
		List<SimulationResult> results = simulation.runSimulations(bais);
		
		for (int i=0; i < results.size(); ++i) {
			String expectedResult = output.get(i);
			SimulationResult result = results.get(i);
			assertEquals(expectedResult, result.toString());
		}
	}

}
