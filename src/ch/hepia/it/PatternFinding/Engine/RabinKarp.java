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
	private final int base;
	private int ti;

	/**
	 * Constructor for Rabin Karp with custom base
	 *
	 * @param text    The text to search through
	 * @param pattern The pattern to find
	 * @param base    The base
	 */
	public RabinKarp (String text, String pattern, int base) {
		//TODO check when text is empty
		super(text, pattern);
		this.base = base;
		this.m = pattern.length();
		this.t = text.equals("") ? 1 : text.length();
		this.q = text.equals("") ? findCoprimeTo(m) : findCoprimeTo(m, t);
		this.p = hash(pattern);
		this.ti = text.equals("") ? 0 : hash(text);
	}

	/**
	 * Constructor for the Rabin Karp algorithm that will use the default base (128)
	 *
	 * @param text    The text to search through
	 * @param pattern The pattern to find
	 */
	public RabinKarp (String text, String pattern) {
		this(text, pattern, DEFAULT_B);
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
				ti = base * mod(ti - BigInteger.valueOf(base).modPow(BigInteger.valueOf(m - 1), BigInteger.valueOf(q)).intValue() * text.charAt(s - 1), q) + text.charAt(s + m - 1);
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
			hash += mod(BigInteger.valueOf(base).modPow(BigInteger.valueOf(m - i - 1), BigInteger.valueOf(q)).intValue() * text.charAt(i), q);
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

	public int findCoprimeTo (int a) {
		int temp = rnd.nextInt(a);
		while (temp == 0 || gcd(temp, a) != 1)
			temp = rnd.nextInt(a);
		return temp;
	}

	/**
	 * @return Q the coprime to m and t
	 */
	public int getQ () {
		return q;
	}

	/**
	 * @return P the hash of the pattern
	 */
	public int getP () {
		return p;
	}

	/**
	 * @return The base
	 */
	public int getBase () {
		return base;
	}
}
