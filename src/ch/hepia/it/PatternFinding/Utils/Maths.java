package ch.hepia.it.PatternFinding.Utils;

import java.util.Random;

/**
 * Abstract class containing some maths static function needed by our program
 */
public abstract class Maths {
	private static Random rnd = new Random();

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

	//TODO CHECK IF WE CAN FUSION THESE TWO


	/**
	 * Method to find a coprime to two numbers
	 *
	 * @param a The first number
	 * @param b The second number
	 * @return A coprime to a and b
	 */
	public static int findCoprimeTo (int a, int b) {
		int temp = rnd.nextInt(Integer.max(a, b));
		while (temp == 0 || (gcd(temp, a) != 1 || gcd(temp, b) != 1)) {
			temp = rnd.nextInt(Integer.max(a, b));
		}
		return temp;
	}

	public static int findCoprimeTo (int a) {
		int temp = rnd.nextInt(a);
		while (temp == 0 || gcd(temp, a) != 1)
			temp = rnd.nextInt(a);
		return temp;
	}
}
