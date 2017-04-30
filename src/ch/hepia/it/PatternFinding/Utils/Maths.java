package ch.hepia.it.PatternFinding.Utils;

public abstract class Maths {

	public static long mod (long x, long y) {
		long result = x % y;
		return result < 0 ? result + y : result;
	}
}
