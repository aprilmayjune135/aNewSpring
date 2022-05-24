package data;

import java.util.Vector;

public class Grid {
	/* private members */
	private	Person[][] matrix;
	private int	size;
	private int infectionThreshold;
	private int recoveryThreshold;

	/* public methods */
	public void initGrid(InputData input) {
		size = input.getGridScale();
		matrix = new Person[size][size];
		for (int x = 0; x < size; ++x) {
			for (int y = 0; y < size; ++y) {
				matrix[x][y] = new Person();
			}
		}
		Vector<InputInfected> infected = input.getInfections();
		for (int i = 0; i < infected.size(); ++i) {
			matrix[infected.get(i).axisX - 1][infected.get(i).axisY - 1].status = 1;
		}
		infectionThreshold = input.getInfectionThreshold();
		recoveryThreshold = input.getRecoveryThreshold();
	}

	public void evaluate() {
		updateLastRound();
		for (int x = 0; x < size; ++x) {
			for (int y = 0; y < size; ++y) {
				if (matrix[x][y].status == 0) {
					matrix[x][y].status = checkInfection(x, y);
				}
				else {
					matrix[x][y].status = checkRecovery(x, y);
				}
			}
		}
	}

	public void	print() {
		for (int x = 0; x < size; ++x) {
			for (int y = 0; y < size; ++y) {
				matrix[x][y].print();
			}
			System.out.print("\n");
		}
	}

	/* private methods */
	private void updateLastRound() {
		for (int x = 0; x < size; ++x) {
			for (int y = 0; y < size; ++y) {
				matrix[x][y].lastRound = matrix[x][y].status;
			}
		}
	}

	private int countInfectedContactsY(int x, int y) {
		int count = 0;
		if (y > 0) {
			count += matrix[x][y - 1].lastRound;
		}
		count += matrix[x][y].lastRound;
		if (y < size - 1) {
			count += matrix[x][y + 1].lastRound;
		}
		return count;
	}

	private int countInfectedContacts(int x, int y) {
		int count = 0;
		if (x > 0) {
			count += countInfectedContactsY(x - 1, y);
		}
		count += countInfectedContactsY(x, y);
		if (x < size - 1) {
			count += countInfectedContactsY(x + 1, y);
		}
		count -= matrix[x][y].lastRound;
		return count;
	}

	private int checkRecovery(int x, int y) {
		if (countInfectedContacts(x, y) > recoveryThreshold) {
			return 0;
		}
		return 1;
	}

	private int checkInfection(int x, int y) {
		if (countInfectedContacts(x, y) > infectionThreshold) {
			return 1;
		}
		return 0;
	}

}
