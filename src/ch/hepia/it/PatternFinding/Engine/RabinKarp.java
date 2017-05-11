package ch.hepia.it.PatternFinding.Engine;

import ch.hepia.it.PatternFinding.DataStructures.PatternOccurences;

import java.math.BigInteger;

import static ch.hepia.it.PatternFinding.Utils.Maths.mod;

/**
 * Class implementing the Rabin Karp algorithm
 */
public class RabinKarp extends PatternFinder {
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
		this.q = BigInteger.valueOf(Integer.max(m, t)).nextProbablePrime().intValue();
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
	 * @return A PatternOccurences instance of the indices of the pattern (starting at 0)
	 */
	@Override
	public PatternOccurences getOccurences () {
		PatternOccurences occurences = new PatternOccurences();
		int i = 0;
		for (int s = 0; s <= t - m; s++) {
			if (s != 0) {
				ti = base * mod(ti - BigInteger.valueOf(base).modPow(BigInteger.valueOf(m - 1), BigInteger.valueOf(q)).intValue() * text.charAt(s - 1), q) + text.charAt(s + m - 1);
				ti = mod(ti, q);
			}
			if (mod(p, q) == mod(ti, q)) {
				i++;
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
			hash *= base;
			hash += text.charAt(i);
			hash = mod(hash, q);
		}
		return hash;
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
