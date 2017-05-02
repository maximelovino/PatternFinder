package ch.hepia.it.PatternFinding.Test;

import ch.hepia.it.PatternFinding.Engine.FiniteStateMachineFinder;
import ch.hepia.it.PatternFinding.Engine.RabinKarp;

import java.util.ArrayList;
import java.util.List;

public class TestFile {
	public static void main (String[] args) {
		String text = "ababababacaabababaca";
		text = "abababacababacabababaca";
		String pattern = "ababaca";


		text = "212121212131212 wwwwww bwwwawwww bonsbonsbonsbonsbonsabonsbonsbons 1111abt1111ab1111abt1111ab111 12121111abt1111ab1212 12w wwwab12 w1111abww1111abwww1111abt1111abwwww bonswbonsbonswbonsbonsbons 12ww1212www121212wwww";
		pattern = "1212";


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
