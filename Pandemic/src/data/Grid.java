package data;

import java.util.Vector;
import util.Color;

public class Grid {
	/* private members */
	private	int[][] matrix;
	private int	size;

	/* methods */
	public void initGrid(int n, Vector<InputInfected> infected) {
		size = n;
		matrix = new int[n][n];
		for (int x = 0; x < size; ++x) {
			for (int y = 0; y < size; ++y) {
				matrix[x][y] = 0;
			}
		}
		for (int i = 0; i < infected.size(); ++i) {
			matrix[infected.get(i).axisX - 1][infected.get(i).axisY - 1] = 1;
		}
	}

	public void	print() {
		for (int x = 0; x < size; ++x) {
			for (int y = 0; y < size; ++y) {
				printPerson((matrix[x][y]));
			}
			System.out.print("\n");
		}
	}

	private void printPerson(int n) {
		if (n == 0) {
			System.out.print(Color.GREEN + "." + Color.RESET);
		}
		else {
			System.out.print(Color.RED + "X" + Color.RESET);
		}
	}

}
