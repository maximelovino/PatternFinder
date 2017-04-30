package ch.hepia.it.PatternFinding.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RabinKarp implements PatternFinder {
	private static Random rnd = new Random();
	private static RabinKarp instance = new RabinKarp();

	private RabinKarp () {
	}

	public static RabinKarp getInstance () {
		return instance;
	}

	@Override
	public List<Integer> getOccurences (String text, String pattern) {
		List<Integer> occurences = new ArrayList<>();
		//b should be next prime bigger than size of alphabet
		int b = 128;
		int m = pattern.length();
		int t = text.length();

		int q = findCoprimeTo(t, m);
		long p = 0;
		long ti = 0;

		for (int i = 0; i < m; i++) {
			ti += (long) Math.pow(b, m - i - 1) * text.charAt(i);
			p += (long) Math.pow(b, m - i - 1) * pattern.charAt(i);
		}

		for (int s = 0; s <= t - m; s++) {
			if (s != 0) {
				ti = b * (ti - (long) (Math.pow(b, m - 1) * text.charAt(s - 1))) + text.charAt(s + m - 1);
			}
			if (ti < 0) {
				System.err.println("PROBLEM " + ti + "\t" + s);
			}
			if ((p % q) == (ti % q)) {
				if (text.substring(s, s + m).equals(pattern)) {
					occurences.add(s);
				}
			}
		}

		return occurences;
	}

	private int findCoprimeTo (int m, int t) {
		int temp = rnd.nextInt(Integer.max(m, t));
		while (temp == 0 || (gcd(temp, m) != 1 || gcd(temp, t) != 1)) {
			temp = rnd.nextInt(Integer.max(m, t));
		}
		return temp;
	}

	private int gcd (int a, int b) {
		int t;
		while (b != 0) {
			t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
}
