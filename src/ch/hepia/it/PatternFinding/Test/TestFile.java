package ch.hepia.it.PatternFinding.Test;

import ch.hepia.it.PatternFinding.Engine.*;

public class TestFile {
	private static String pattern1 = "1212";
	private static String pattern2 = "wwww";
	private static String pattern3 = "bonsbonsbons";
	private static String pattern4 = "1111abt1111ab";

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
		bm = new BoyerMoore(text, pattern1);
		bm = new BoyerMoore(text, pattern2);
		bm = new BoyerMoore(text, pattern3);
		bm = new BoyerMoore(text, pattern4);
	}

}
