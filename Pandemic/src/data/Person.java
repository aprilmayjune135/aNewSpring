package data;

import util.Color;

public class Person {
	public int lastRound = 0;
	public int status = 0;

	public void print() {
		if (status == 0) {
			System.out.print(Color.GREEN + "." + Color.RESET);
		}
		else {
			System.out.print(Color.RED + "X" + Color.RESET);
		}
	}
}
