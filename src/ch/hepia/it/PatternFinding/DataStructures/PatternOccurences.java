package ch.hepia.it.PatternFinding.DataStructures;

import java.util.ArrayList;

/**
 * Class representing a result set of occurences
 * Basically, it's just an ArrayList of Integers for which we override the output
 */
public class PatternOccurences extends ArrayList<Integer> {

	/**
	 * @return String representation of the occurences
	 */
	@Override
	public String toString () {
		String out = "";
		out += String.valueOf(size()) + "\n";
		for (Integer a : this) {
			out += a.toString() + " ";
		}
		return out;
	}
}
