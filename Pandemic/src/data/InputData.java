package data;
import java.util.Vector;

import util.Parse;

public class InputData {
	/* private members */
	private int gridScale = 0;
	private int rounds = 0;
	private int infectionThreshold = 0;
	private int recoveryThreshold = 0;
	private Vector<InputInfected>	infections;

	/* getters */
	public int getGridScale() { return gridScale; }
	public int getRounds() { return rounds; }
	public int getInfectionThreshold() { return infectionThreshold; }
	public int getRecoveryThreshold() { return recoveryThreshold; }
	public Vector<InputInfected> getInfections() { return infections; }

	/* methods */
	public int parseInput(String[] args) {
		if (args.length != 5) {
			System.out.println("Error: Wrong number of arguments!");
			return -1;
		}
		try {
			gridScale = Parse.parseNumber(args[0], "Grid scale", 10000); // TODO: to review max
			rounds = Parse.parseNumber(args[1], "Number of rounds", 10000); // TODO: to review max
			infectionThreshold = Parse.parseNumber(args[2], "Unfection threshold", 7);
			recoveryThreshold = Parse.parseNumber(args[3], "Recovery threshold", 7);
			infections = Parse.parseInputInfected(args[4], gridScale);
		}
		catch (Exception ex) {
			System.out.println("Error: Invalid input: " + ex.getMessage());
			return -1;
		}
		// if (infectionThreshold >= recoveryThreshold ) {
		// 	System.out.println("Error: Invalid input: " + "Infection threshold: cannot be higher than recovery threshold");
		// 	return -1;
		// }
		return 0;
	}

	public void print() {
		System.out.println("gridScale: " + gridScale);
		System.out.println("rounds: " + rounds);
		System.out.println("infectionThreshold: " + infectionThreshold);
		System.out.println("recoveryThreshold: " + recoveryThreshold);
		for (int i = 0; i < infections.size(); ++i) {
			System.out.println(infections.get(i).axisX + "-" + infections.get(i).axisY);
		}
	}

}
