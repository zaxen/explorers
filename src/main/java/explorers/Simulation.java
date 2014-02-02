package explorers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {

	public Simulation() {
	}

	/**
	 * Reads a simulation from the input stream.
	 * 
	 * The simulation is in TODO xyz format...
	 * 
	 * @param inputStream
	 *            The input stream to read from
	 * @return The list of results
	 */
	public List<SimulationResult> runSimulations(InputStream inputStream) {
		try (Scanner s = new Scanner(inputStream)) {
			final Bounds bounds = new Bounds(s.nextInt(), s.nextInt());
			s.nextLine();

			final List<SimulationResult> results = new ArrayList<>();

			while (s.hasNextLine()) {
				Explorer explorer = null;
				try {
					explorer = new Explorer(bounds, s.nextInt(), s.nextInt(),
							Direction.valueOf(s.next().trim()));
					s.nextLine();
					explorer.run(s.nextLine());
					results.add(SimulationResult.success(explorer));
				} catch (Exception e) {
					results.add(SimulationResult.error(explorer, e));
				}
			}

			return results;
		}
	}

	public static void main(String[] args) {
		for (SimulationResult result : new Simulation()
				.runSimulations(System.in)) {
			System.out.println(result);
		}
	}

}
