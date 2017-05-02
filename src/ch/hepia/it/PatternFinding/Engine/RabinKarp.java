package ch.hepia.it.PatternFinding.Engine;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ch.hepia.it.PatternFinding.Utils.Maths.gcd;
import static ch.hepia.it.PatternFinding.Utils.Maths.mod;

public class RabinKarp extends PatternFinder {
	private static Random rnd = new Random();
	private final static int B = 128;
	private final int m;
	private final int t;
	private final int q;
	private final int p;
	private int ti;

	public RabinKarp (String text, String pattern) {
		super(text, pattern);
		this.m = pattern.length();
		this.t = text.length();
		this.q = findCoprimeTo(m, t);
		this.p = hash(pattern);
		this.ti = hash(text);
	}

	@Override
	public List<Integer> getOccurences () {
		List<Integer> occurences = new ArrayList<>();
		for (int s = 0; s <= t - m; s++) {
			if (s != 0) {
				ti = B * mod(ti - BigInteger.valueOf(B).modPow(BigInteger.valueOf(m - 1), BigInteger.valueOf(q)).intValue() * text.charAt(s - 1), q) + text.charAt(s + m - 1);
				ti = mod(ti, q);
			}
			if (mod(p, q) == mod(ti, q)) {
				if (text.substring(s, s + m).equals(pattern)) {
					occurences.add(s);
				}
			}
		}
		return occurences;
	}

	private int hash (String text) {
		int hash = 0;
		for (int i = 0; i < m; i++) {
			hash += mod(BigInteger.valueOf(B).modPow(BigInteger.valueOf(m - i - 1), BigInteger.valueOf(q)).intValue() * text.charAt(i), q);
			hash = mod(hash, q);
		}
		return hash;
	}

	private int findCoprimeTo (int m, int t) {
		int temp = rnd.nextInt(Integer.max(m, t));
		while (temp == 0 || (gcd(temp, m) != 1 || gcd(temp, t) != 1)) {
			temp = rnd.nextInt(Integer.max(m, t));
		}
		return temp;
	}
}
