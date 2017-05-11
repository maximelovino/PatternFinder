package ch.hepia.it.PatternFinding.Engine;

import ch.hepia.it.PatternFinding.DataStructures.PatternOccurences;

/**
 * Class implementing the naive pattern search, for comparison purposes
 */
public class NaiveSearch extends PatternFinder {

	/**
	 * Constructor for naive search
	 *
	 * @param text    The text to search through
	 * @param pattern The pattern to find
	 */
	public NaiveSearch (String text, String pattern) {
		super(text, pattern);
	}

	/**
	 * Method to find the occurences of the pattern in the text
	 *
	 * @return A PatternOccurences instance of the indices of the pattern (starting at 0)
	 */
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
