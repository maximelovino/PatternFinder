package ch.hepia.it.PatternFinding.Engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoyerMoore extends PatternFinder {
	private Map<Character, Integer> map1;
	private Map<String, Integer> map2;

	public BoyerMoore (String text, String pattern) {
		super(text, pattern);
		constructMaps();
	}

	@Override
	public List<Integer> getOccurences () {
		return null;
	}

	private void constructMaps () {
		map1 = new HashMap<>();
		map2 = new HashMap<>();
		for (int i = pattern.length() - 1; i >= 0; i--) {
			Character currentChar = pattern.charAt(i);
			map1.putIfAbsent(currentChar, pattern.length() - 1 - i);
			int moveLeft = findSubstringMoveFromRight(pattern.substring(i), i);
			System.out.println(pattern.substring(i) + "\t" + moveLeft);
		}
	}

	private int findSubstringMoveFromRight (String substring, int startIndex) {
		for (int i = startIndex - substring.length(); i >= 0; i--) {
			if ((i != 0 && pattern.charAt(i - 1) != pattern.charAt(startIndex - 1)) && (pattern.substring(i, i + substring.length()).equals(substring)))
				return startIndex - i;
		}
		return startIndex + 1;
	}
}
