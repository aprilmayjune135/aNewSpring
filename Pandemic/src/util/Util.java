package util;
import java.lang.Integer;
import java.util.Vector;

import data.InputInfected;

public class Util {
	public int parseNumber(String arg, String inputType, int Max) throws Exception {
		int ret = -1;
		try {
			ret = Integer.parseInt(arg);
		}
		catch (NumberFormatException ex) {
			throw new Exception(inputType + ": not an integer");
		}
		if (ret < 1) {
			throw new Exception(inputType + ": not positive");
		}
		else if (ret > Max) {
			throw new Exception(inputType + ": too big");
		}
		return ret;
	}

	/* note: do not check for duplicate infections */
	public Vector<InputInfected> parseInputInfected(String arg, int gridScale) throws Exception {
		Vector<InputInfected> ret = new Vector<InputInfected>();
		try {
			arg = arg.replace("[<", "");
			arg = arg.replace(">]", "");
			if (!Character.isDigit(arg.charAt(0)) || !Character.isDigit(arg.charAt(arg.length() - 1))) {
				throw new Exception("front/back of the input string is not valid");
			}
			String[] lines = arg.split(">,<");
			for (int i = 0; i < lines.length; ++i) {
				InputInfected input = parseSingleInputInfected(lines[i], gridScale);
				ret.add(input);
			}
		}
		catch (Exception ex) {
			throw new Exception("Infected persons input: " + ex.getMessage());
		}
		return ret;
	}

	private InputInfected	parseSingleInputInfected(String str, int gridScale) throws Exception {
		String[] numbers = str.split(",");
		if (numbers.length != 2) {
			throw new Exception(str);
		}
		int x = 0, y = 0;
		try {
			x = Integer.parseInt(numbers[0]);
			y = Integer.parseInt(numbers[1]);
		}
		catch (Exception ex) {
			throw new Exception(str + ": not an integer");
		}
		if (x < 1 || x > gridScale || y < 1 || y > gridScale) {
			throw new Exception(str + ": position outside of grid scope");
		}
		return new InputInfected(x, y);
	}

}
