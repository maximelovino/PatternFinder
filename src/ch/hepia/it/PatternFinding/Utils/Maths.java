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

	public static int gcd (int a, int b) {
		int t;
		while (b != 0) {
			t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
}
