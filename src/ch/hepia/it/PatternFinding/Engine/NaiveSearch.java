package ch.hepia.it.PatternFinding.Engine;

import java.util.ArrayList;
import java.util.List;

public class NaiveSearch extends PatternFinder {
	public NaiveSearch (String text, String pattern) {
		super(text, pattern);
	}

	@Override
	public List<Integer> getOccurences () {
		List<Integer> occurences = new ArrayList<>();

		for (int i = 0; i <= text.length() - pattern.length(); i++) {
			if (text.substring(i, i + pattern.length()).equals(pattern)) {
				occurences.add(i);
			}
		}
		return occurences;
	}
}
