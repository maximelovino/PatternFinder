package ch.hepia.it.PatternFinding.DataStructures;

import java.util.ArrayList;

public class PatternOccurences extends ArrayList<Integer> {

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
