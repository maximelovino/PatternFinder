package ch.hepia.it.PatternFinding.Engine;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ch.hepia.it.PatternFinding.Utils.Maths.gcd;
import static ch.hepia.it.PatternFinding.Utils.Maths.mod;

/**
 * Class implementing the Rabin Karp algorithm
 */
public class RabinKarp extends PatternFinder {
	private static Random rnd = new Random();
	private final static int DEFAULT_B = 128;
	private final int m;
	private final int t;
	private final int q;
	private final int p;
	private final int b;
	private int ti;

	/**
	 * Constructor for the Rabin Karp algorithm
	 *
	 * @param text    The text to search through
	 * @param pattern The pattern to find
	 */
	public RabinKarp (String text, String pattern) {
		super(text, pattern);
		this.m = pattern.length();
		this.t = text.length();
		this.q = findCoprimeTo(m, t);
		this.p = hash(pattern);
		this.ti = hash(text);
		this.b = DEFAULT_B;
	}

	/**
	 * Method to find the occurences of the pattern in the text
	 *
	 * @return A list of the indices of the pattern (starting at 0)
	 */
	@Override
	public List<Integer> getOccurences () {
		List<Integer> occurences = new ArrayList<>();
		for (int s = 0; s <= t - m; s++) {
			if (s != 0) {
				ti = b * mod(ti - BigInteger.valueOf(b).modPow(BigInteger.valueOf(m - 1), BigInteger.valueOf(q)).intValue() * text.charAt(s - 1), q) + text.charAt(s + m - 1);
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

	/**
	 * Rabin Karp hash method
	 *
	 * @param text The text to hash
	 * @return The hash of the text
	 */
	private int hash (String text) {
		int hash = 0;
		for (int i = 0; i < m; i++) {
			hash += mod(BigInteger.valueOf(b).modPow(BigInteger.valueOf(m - i - 1), BigInteger.valueOf(q)).intValue() * text.charAt(i), q);
			hash = mod(hash, q);
		}
		return hash;
	}

	/**
	 * Method to find a coprime to two numbers
	 *
	 * @param a The first number
	 * @param b The second number
	 * @return A coprime to a and b
	 */
	private int findCoprimeTo (int a, int b) {
		int temp = rnd.nextInt(Integer.max(a, b));
		while (temp == 0 || (gcd(temp, a) != 1 || gcd(temp, b) != 1)) {
			temp = rnd.nextInt(Integer.max(a, b));
		}
		return temp;
	}

	public int getQ () {
		return q;
	}

	public int getP () {
		return p;
	}

	public int getB () {
		return b;
	}
}
