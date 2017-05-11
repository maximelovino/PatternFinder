package ch.hepia.it.PatternFinding.Engine;

import ch.hepia.it.PatternFinding.DataStructures.PatternOccurences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the Boyer-Moore algorithm
 */
public class BoyerMoore extends PatternFinder {
	private Map<Character, Integer> map1;
	private int[] tab2;
	private List<Character> chars;

	/**
	 * Constructor for Boyer-Moore search
	 *
	 * @param text    The text to search through
	 * @param pattern The pattern to find
	 */
	public BoyerMoore (String text, String pattern) {
		super(text, pattern);
		preRoll();
	}

	/**
	 * Method to find the occurences of the pattern in the text
	 *
	 * @return A PatternOccurences instance of the indices of the pattern (starting at 0)
	 */
	@Override
	public PatternOccurences getOccurences () {
		PatternOccurences occurences = new PatternOccurences();
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

	/**
	 * Function to do all the pre-treatment for Boyer-Moore
	 */
	private void preRoll () {
		map1 = new HashMap<>();
		chars = new ArrayList<>();
		for (int i = pattern.length() - 1; i >= 0; i--) {
			Character currentChar = pattern.charAt(i);
			if (!map1.containsKey(currentChar)) {
				map1.put(currentChar, pattern.length() - 1 - i);
				chars.add(currentChar);
			}
		}
		makeTab2();
	}

	/**
	 * Function to prepare the second tab of Boyer-Moore
	 */
	private void makeTab2 () {
		tab2 = new int[pattern.length()];
		for (int i = pattern.length() - 1; i >= 1; i--) {
			String sub = pattern.substring(i);
			Character toExclude = pattern.charAt(i - 1);
			int tempLast = pattern.lastIndexOf(sub);
			while (tempLast > 0 && pattern.charAt(tempLast - 1) == toExclude) {
				tempLast = pattern.lastIndexOf(sub, tempLast - 1);
			}
			if (tempLast == -1) {
				do {
					sub = sub.substring(1);
				} while (!sub.equals(pattern.substring(0, sub.length())));
				tab2[pattern.length() - i - 1] = pattern.length() - sub.length();
			} else {
				tab2[pattern.length() - i - 1] = pattern.length() - tempLast - sub.length();
			}
		}
		//last one is always same as second to last
		tab2[pattern.length() - 1] = tab2[pattern.length() - 2];
	}

	/**
	 * Function to display the values of the two tabs for Boyer-Moore
	 */
	public void displayTabs () {
		for (int i = chars.size() - 1; i >= 0; i--) {
			System.out.print(map1.get(chars.get(i)).toString() + " ");
		}

		System.out.print(pattern.length());
		System.out.println();

		for (int val : tab2) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
}
