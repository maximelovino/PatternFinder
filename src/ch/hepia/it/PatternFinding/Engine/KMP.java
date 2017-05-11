package ch.hepia.it.PatternFinding.Engine;

import ch.hepia.it.PatternFinding.DataStructures.PatternOccurences;

/**
 * Implementation of Knut-Moris-Pratt algorithm
 */
public class KMP extends PatternFinder {
	private int[] piArray;

	/**
	 * Constructor for KMP
	 *
	 * @param text    The text to search through
	 * @param pattern The pattern to find
	 */
	public KMP (String text, String pattern) {
		super(text, pattern);
		buildPiArray();
	}

	/**
	 * Method to find the occurences of the pattern in the text
	 *
	 * @return A PatternOccurences instance of the indices of the pattern (starting at 0)
	 */
	@Override
	public PatternOccurences getOccurences () {
		PatternOccurences ocurrences = new PatternOccurences();

		int q = -1;
		for (int i = 0; i < text.length(); i++) {
			while (q > -1 && pattern.charAt(q + 1) != text.charAt(i)) {
				q = piArray[q];
			}
			if (pattern.charAt(q + 1) == text.charAt(i)) {
				q = q + 1;
			}
			if (q == pattern.length() - 1) {
				ocurrences.add(i - pattern.length() + 1);
				q = piArray[q];
			}
		}
		return ocurrences;
	}

	/**
	 * Function to build the array of PIs which is the pre-treatment for KMP
	 */
	private void buildPiArray () {
		piArray = new int[pattern.length()];
		for (int i = 0; i < pattern.length(); i++) {
			String suffixable = pattern.substring(0, i + 1);
			int maxK = -1;
			for (int k = 0; k < i; k++) {
				String sub = pattern.substring(0, k + 1);
				if (isSuffix(sub, suffixable))
					maxK = k;
			}
			piArray[i] = maxK;
		}
	}

	/**
	 * Function to check if a string is suffix of another
	 * @param suffix    The suffix to tests
	 * @param text    The text to test with
	 * @return If suffix is a suffix of text
	 */
	private boolean isSuffix (String suffix, String text) {
		return text.substring(text.length() - suffix.length(), text.length()).equals(suffix);
	}

	/**
	 * Method to display the array of PIs
	 */
	public void printPiArray () {
		for (int aPiArray : piArray) {
			System.out.print(aPiArray + " ");
		}
		System.out.println();
	}


}
