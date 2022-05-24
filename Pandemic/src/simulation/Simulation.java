package simulation;

import data.Grid;
import data.InputData;
import util.Color;

public class Simulation {
	/* private members */
	private InputData input = new InputData();
	private Grid grid = new Grid();

	/* public methods */
	public void run(String[] args) {
		if (init(args) == -1) {
			return ;
		}
		runRounds(false);
	}
	
	/* private methods */
	private int	init(String[] args) {
		if (input.parseInput(args) == -1) {
			return -1;
		}
		grid.initGrid(input);
		return 0;
	}

	private void runRounds(boolean isPrintProcess) {
		System.out.println(Color.PURPLE_BOLD + "[ INIT ]" + Color.RESET);
		grid.print();

		for (int i = 1; i < input.getRounds() + 1; ++i) {
			grid.evaluate();
			if (isPrintProcess) {
				System.out.println(Color.PURPLE_BOLD + "[ ROUND " + i + "]" + Color.RESET);
				grid.print();
			}
		}

		System.out.println(Color.PURPLE_BOLD + "[ FINAL ]" + Color.RESET);
		grid.print();
	}

}
