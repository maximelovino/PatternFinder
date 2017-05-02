package ch.hepia.it.PatternFinding.Engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FiniteStateMachineFinder extends PatternFinder {
	private final int[][] transitions;

	public FiniteStateMachineFinder (String text, String pattern) {
		super(text, pattern);
		this.transitions = getTransitionTable(pattern);
	}


	@Override
	public List<Integer> getOccurences () {
		List<Integer> occurences = new ArrayList<>();

		int state = 0;

		for (int i = 0; i < text.length(); i++) {
			state = transitions[state][(int) text.charAt(i)];
			if (state == (transitions.length - 1)) {
				state = 0;
				occurences.add(i - transitions.length + 2);
			}
		}


		return occurences;
	}

	private int[][] getTransitionTable (String pattern) {
		int[][] transitions = new int[pattern.length()][128];
		HashMap<Character, List<Integer>> charOccurences = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			//if we see the first letter of the pattern, by default we go to state 1
			transitions[i][(int) pattern.charAt(0)] = 1;

			Character currentChar = pattern.charAt(i);

			List<Integer> listCurrentChar = charOccurences.get(currentChar);


			if (listCurrentChar == null) {
				listCurrentChar = new ArrayList<>();
				charOccurences.put(currentChar, listCurrentChar);
			}
			listCurrentChar.add(i);
			for (Character c : charOccurences.keySet()) {
				List<Integer> charList = charOccurences.get(c);
				Integer latestOccurence = null;
				boolean found = true;
				if (c != currentChar) {
					for (int j = charList.size() - 1; j >= 0; j--) {
						found = true;
						latestOccurence = charList.get(j);
						for (int k = 1; k <= Math.min(i, latestOccurence); k++) {
							if (pattern.charAt(latestOccurence - k) != pattern.charAt(i - k)) {
								found = false;
								break;
							}
						}
						if (found) {
							transitions[i][c] = latestOccurence + 1;
							break;
						}
					}
				}
			}
			transitions[i][(int) currentChar] = i + 1;
		}
		return transitions;
	}

	public static void printStates (int[][] transitions) {
		for (int i = 0; i < transitions.length; i++) {
			System.out.print("STATE " + i + "\t\t");
			for (int j = 0; j < transitions[i].length; j++) {
				if (transitions[i][j] != 0) {
					System.out.print(String.valueOf((char) j) + " : " + transitions[i][j] + "\t");
				}
			}
			System.out.println();
		}
	}
}
