package ch.hepia.it.PatternFinding.Engine;

import java.util.List;

public class KMP extends PatternFinder {
	private int[] piArray;

	public KMP (String text, String pattern) {
		super(text, pattern);
		buildPiArray();
		printPiArray();
	}

	@Override
	public List<Integer> getOccurences () {
		return null;
	}

	private void buildPiArray () {
		piArray = new int[pattern.length()];
		for (int i = 0; i < pattern.length(); i++) {
			String suffixable = new String(pattern).substring(0, i + 1);
			int maxK = -1;
			for (int k = 0; k < i; k++) {
				String sub = new String(pattern).substring(0, k + 1);
				if (isSuffix(sub, suffixable))
					maxK = k;
			}
			piArray[i] = maxK;
		}
	}

	private boolean isSuffix (String suffix, String text) {
		return new String(text).substring(text.length() - suffix.length(), text.length()).equals(suffix);
	}

	private void printPiArray () {
		for (int i = 0; i < piArray.length; i++) {
			System.out.print(piArray[i] + "\t");
		}
		System.out.println();
	}


}
