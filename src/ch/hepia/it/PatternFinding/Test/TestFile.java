package ch.hepia.it.PatternFinding.Test;

import ch.hepia.it.PatternFinding.Engine.FiniteStateMachineFinder;
import ch.hepia.it.PatternFinding.Engine.KMP;
import ch.hepia.it.PatternFinding.Engine.RabinKarp;

import java.util.ArrayList;
import java.util.List;

public class TestFile {
	public static void main (String[] args) {
		String text = "ababababacaabababaca";
		text = "abababacababacabababaca";
		String pattern = "ababaca";


		KMP kmp = new KMP(text, pattern);
		System.out.println(naiveAlgo(text, pattern));
		System.out.println("====================");
		System.out.println(new RabinKarp(text, pattern).getOccurences());
		System.out.println("====================");
		System.out.println(new FiniteStateMachineFinder(text, pattern).getOccurences());
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
