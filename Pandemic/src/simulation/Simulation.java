package simulation;

import data.Grid;
import data.InputData;

public class Simulation {
	/* private members */
	private InputData input = new InputData();
	private Grid grid = new Grid();

	/* public methods */
	public void run(String[] args) {
		if (input.parseInput(args) == -1) {
			return ;
		}
		grid.initGrid(input.getGridScale(), input.getInfections());
		grid.print();
	}


}
