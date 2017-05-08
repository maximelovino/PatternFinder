package ch.hepia.it.PatternFinding.Engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoyerMoore extends PatternFinder {
	private Map<Character, Integer> map1;
	private int[] tab2;

	public BoyerMoore (String text, String pattern) {
		super(text, pattern);
		preRoll();
	}

	@Override
	public List<Integer> getOccurences () {
		List<Integer> occurences = new ArrayList<>();
		int s = pattern.length();
		while (s <= text.length()) {
			int j = pattern.length();
			while (j > 0 && text.charAt(s - pattern.length() + j - 1) == pattern.charAt(j - 1)) {
				j = j - 1;
			}
			if (j == 0) {
				occurences.add(s - pattern.length());
			}
			if (j == pattern.length()) {
				s = s + (map1.get(text.charAt(s - 1)) == null ? pattern.length() : map1.get(text.charAt(s - 1)));
			} else {
				s = s + tab2[pattern.length() - j - 1];
			}
		}
		return occurences;
	}

	private void preRoll () {
		map1 = new HashMap<>();
		for (int i = pattern.length() - 1; i >= 0; i--) {
			Character currentChar = pattern.charAt(i);
			map1.putIfAbsent(currentChar, pattern.length() - 1 - i);
		}
		makeTab2();
	}

	private void makeTab2 () {
		tab2 = new int[pattern.length()];
		for (int i = pattern.length() - 1; i >= 1; i--) {
			String sub = pattern.substring(i);
			Character toExclude = pattern.charAt(i - 1);
			int tempLast = pattern.lastIndexOf(sub);
			while (tempLast > 0 && pattern.charAt(tempLast - 1) == toExclude) {
				tempLast = pattern.lastIndexOf(sub, tempLast - 1);
			}
			boolean found = false;
			if (tempLast == -1) {
				do {
					if (sub.length() > 1) {
						sub = sub.substring(1);
					} else {
						tab2[pattern.length() - i - 1] = pattern.length();
						found = true;
						break;
					}
				} while (!sub.equals(pattern.substring(0, sub.length())));
				if (!found)
					tab2[pattern.length() - i - 1] = pattern.length() - sub.length();
			} else {
				tab2[pattern.length() - i - 1] = pattern.length() - tempLast - sub.length();
			}
		}
		//last one is always same as second to last
		tab2[pattern.length() - 1] = tab2[pattern.length() - 2];
	}
}
