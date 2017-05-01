package ch.hepia.it.PatternFinding.Utils;

public abstract class Maths {

	public static long mod (long x, long y) {
		long result = x % y;
		return result < 0 ? result + y : result;
	}

	public static int mod (int x, int y) {
		int result = x % y;
		return result < 0 ? result + y : result;
	}
}
