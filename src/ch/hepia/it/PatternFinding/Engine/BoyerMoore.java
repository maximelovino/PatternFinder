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
		}
	}
}
