package ch.hepia.it.PatternFinding.Test;

import ch.hepia.it.PatternFinding.Engine.*;

public class TestFile {
	public static void main (String[] args) {
		String text = "ababababacaabababaca";
		text = "abababacababacabababaca";
		String pattern = "ababaca";


		System.out.println(new NaiveSearch(text, pattern).getOccurences());
		System.out.println("====================");
		System.out.println(new RabinKarp(text, pattern).getOccurences());
		System.out.println("====================");
		System.out.println(new FiniteStateMachineFinder(text, pattern).getOccurences());
		System.out.println("====================");
		System.out.println(new KMP(text, pattern).getOccurences());

		pattern = "anpanman";
		BoyerMoore bm = new BoyerMoore(text, pattern);
	}

}
