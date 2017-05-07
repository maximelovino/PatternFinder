package ch.hepia.it.PatternFinding.Engine;

import java.util.List;

public abstract class PatternFinder {
	protected String text;
	protected String pattern;


	protected PatternFinder (String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
	}

	public abstract List<Integer> getOccurences ();
}
