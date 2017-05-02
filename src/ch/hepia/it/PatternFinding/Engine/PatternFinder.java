package ch.hepia.it.PatternFinding.Engine;

import java.util.List;

/**
 * @author Maxime Lovino
 * @date 27.04.17
 * @package ch.hepia.it.PatternFinding.Engine
 * @project PatternFinding
 */

public abstract class PatternFinder {
	protected String text;
	protected String pattern;


	protected PatternFinder (String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
	}

	public abstract List<Integer> getOccurences ();
}
