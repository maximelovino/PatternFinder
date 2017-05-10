package ch.hepia.it.PatternFinding.Engine;

import ch.hepia.it.PatternFinding.DataStructures.PatternOccurences;

import java.util.ArrayList;
import java.util.List;

public class NaiveSearch extends PatternFinder {
	public NaiveSearch (String text, String pattern) {
		super(text, pattern);
	}

	@Override
	public PatternOccurences getOccurences () {
		PatternOccurences occurences = new PatternOccurences();

		for (int i = 0; i <= text.length() - pattern.length(); i++) {
			if (text.substring(i, i + pattern.length()).equals(pattern)) {
				occurences.add(i);
			}
		}
		return occurences;
	}
}
