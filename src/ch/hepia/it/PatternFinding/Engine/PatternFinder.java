package ch.hepia.it.PatternFinding.Engine;

import ch.hepia.it.PatternFinding.DataStructures.PatternOccurences;

import java.util.List;

/**
 * Abstract class that represents the structure of a PatternFinder class
 */
public abstract class PatternFinder {
	protected String text;
	protected String pattern;

	/**
	 * Constructor to be used by children classes
	 *
	 * @param text    The text to search through
	 * @param pattern The pattern to find
	 */
	protected PatternFinder (String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
	}

	/**
	 * Method to find the occurences of the pattern in the text
	 *
	 * @return A PatternOccurences instance of the indices of the pattern (starting at 0)
	 */
	public abstract PatternOccurences getOccurences ();
}
