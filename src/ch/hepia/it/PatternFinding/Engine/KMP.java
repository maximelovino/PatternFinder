package ch.hepia.it.PatternFinding.Engine;

import java.util.ArrayList;
import java.util.List;

public class KMP extends PatternFinder {
	private int[] piArray;

	public KMP (String text, String pattern) {
		super(text, pattern);
		buildPiArray();
	}

	@Override
	public List<Integer> getOccurences () {
		List<Integer> ocurrences = new ArrayList<>();

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

	private boolean isSuffix (String suffix, String text) {
		return text.substring(text.length() - suffix.length(), text.length()).equals(suffix);
	}

	private void printPiArray () {
		for (int i = 0; i < piArray.length; i++) {
			System.out.print(piArray[i] + "\t");
		}
		System.out.println();
	}


}
