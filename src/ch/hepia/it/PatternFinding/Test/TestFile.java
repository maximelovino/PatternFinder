package ch.hepia.it.PatternFinding.Test;

import ch.hepia.it.PatternFinding.Engine.FiniteStateMachineFinder;
import ch.hepia.it.PatternFinding.Engine.RabinKarp;

import java.util.ArrayList;
import java.util.List;

public class TestFile {
	public static void main (String[] args) {
		String text = "ababababacaabababaca";
		String pattern = "ababaca";


		System.out.println(naiveAlgo(text, pattern));
		System.out.println("====================");
		System.out.println(RabinKarp.getInstance().getOccurences(text, pattern));
		System.out.println("====================");
		System.out.println(FiniteStateMachineFinder.getInstance().getOccurences(text, pattern));
	}

	public static List<Integer> naiveAlgo (String text, String pattern) {
		List<Integer> occurences = new ArrayList<>();

		for (int i = 0; i <= text.length() - pattern.length(); i++) {
			if (text.substring(i, i + pattern.length()).equals(pattern)) {
				occurences.add(i);
			}
		}
		return occurences;
	}
}
