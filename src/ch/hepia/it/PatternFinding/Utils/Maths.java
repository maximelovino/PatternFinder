package ch.hepia.it.PatternFinding.Utils;

/**
 * Abstract class containing some maths static function needed by our program
 */
public abstract class Maths {

	/**
	 * Function to calculate the real mod (not the Java remainder)
	 *
	 * @param x A number
	 * @param y A second number
	 * @return x mod y
	 */
	public static long mod (long x, long y) {
		long result = x % y;
		return result < 0 ? result + y : result;
	}

	/**
	 * Function to calculate the real mod (not the Java remainder)
	 *
	 * @param x A number
	 * @param y A second number
	 * @return x mod y
	 */
	public static int mod (int x, int y) {
		int result = x % y;
		return result < 0 ? result + y : result;
	}
}
