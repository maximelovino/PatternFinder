package ch.hepia.it.PatternFinding.Engine;

import java.util.*;

public class FiniteStateMachineFinder extends PatternFinder {
	private int[][] transitions;
	private int finalState;
	private LinkedList<Character> chars;
	private Map<Character, Integer> column;

	public FiniteStateMachineFinder (String text, String pattern) {
		super(text, pattern);
		chars = new LinkedList<>();
		column = new HashMap<>();
		getTransitionTable();
	}


	@Override
	public List<Integer> getOccurences () {
		List<Integer> occurences = new ArrayList<>();

		int state = 0;

		for (int i = 0; i < text.length(); i++) {
			Integer col = column.get(text.charAt(i));
			state = col == null ? 0 : transitions[state][col];
			if (state == finalState) {
				occurences.add(i - pattern.length() + 1);
			}
		}


		return occurences;
	}


	private void getTransitionTable () {
		transitions = new int[pattern.length() + 1][(int) pattern.chars().distinct().count()];
		finalState = pattern.length();
		for (int i = 0; i < transitions.length; i++) {
			Arrays.fill(transitions[i], -1);
		}
		int tempColumnCount = 0;
		for (int i = 0; i < pattern.length(); i++) {
			if (column.putIfAbsent(pattern.charAt(i), tempColumnCount) == null) {
				chars.add(pattern.charAt(i));
				tempColumnCount++;
			}
			transitions[i][column.get(pattern.charAt(i))] = i + 1;
		}

		for (int i = transitions.length - 1; i >= 0; i--) {
			String sub = pattern.substring(0, i);
			for (int j = 0; j < transitions[i].length; j++) {
				if (transitions[i][j] == -1) {
					String newPattern = sub.concat(String.valueOf(chars.get(j)));
					int tempIndex = 1;
					int tempState = -1;
					while (tempState == -1 && tempIndex <= newPattern.length() - 1) {
						tempState = subpatternScrub(newPattern.substring(tempIndex));
						tempIndex++;
					}
					if (tempState != -1) {
						transitions[i][j] = tempState;
					}

				}
			}
		}

		for (int i = 0; i < transitions.length; i++) {
			for (int j = 0; j < transitions[i].length; j++) {
				if (transitions[i][j] == -1) {
					transitions[i][j] = 0;
				}
			}
		}

	}

	private int subpatternScrub (String sub) {
		int state = 0;
		for (int i = 0; i < sub.length(); i++) {
			state = transitions[state][column.get(sub.charAt(i))];
			if (state == -1) {
				return -1;
			}
		}
		return state;
	}


	public void printStates (int[][] transitions) {
		for (int i = 0; i < transitions.length; i++) {
			System.out.print("STATE " + i + "\t\t");
			for (int j = 0; j < transitions[i].length; j++) {
				System.out.print(String.valueOf(chars.get(j)) + " : " + transitions[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
