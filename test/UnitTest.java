import ch.hepia.it.PatternFinding.DataStructures.PatternOccurences;
import ch.hepia.it.PatternFinding.Engine.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UnitTest {
	private String fileName = "tests/data.txt";
	private String text = new String(Files.readAllBytes(Paths.get(fileName)));
	private String pattern1 = "1212";
	private String pattern2 = "wwww";
	private String pattern3 = "bonsbonsbons";
	private String pattern4 = "1111abt1111ab";
	private String pattern5 = "abt1111a";
	private String pattern6 = "bon";
	private String pattern7 = "bons";
	private PatternOccurences answer1, answer2, answer3, answer4, answer5, answer6, answer7;


	public UnitTest () throws IOException {
		answer1 = new NaiveSearch(text, pattern1).getOccurences();
		answer2 = new NaiveSearch(text, pattern2).getOccurences();
		answer3 = new NaiveSearch(text, pattern3).getOccurences();
		answer4 = new NaiveSearch(text, pattern4).getOccurences();
		answer5 = new NaiveSearch(text, pattern5).getOccurences();
		answer6 = new NaiveSearch(text, pattern6).getOccurences();
		answer7 = new NaiveSearch(text, pattern7).getOccurences();
	}

	@Test
	public void testKarp () {
		PatternOccurences candidate1, candidate2, candidate3, candidate4, candidate5, candidate6, candidate7;

		RabinKarp rk1 = new RabinKarp(text, pattern1);
		candidate1 = rk1.getOccurences();
		assertEquals(answer1, candidate1);

		RabinKarp rk2 = new RabinKarp(text, pattern2);
		candidate2 = rk2.getOccurences();
		assertEquals(answer2, candidate2);

		RabinKarp rk3 = new RabinKarp(text, pattern3);
		candidate3 = rk3.getOccurences();
		assertEquals(answer3, candidate3);

		RabinKarp rk4 = new RabinKarp(text, pattern4);
		candidate4 = rk4.getOccurences();
		assertEquals(answer4, candidate4);

		RabinKarp rk5 = new RabinKarp(text, pattern5);
		candidate5 = rk5.getOccurences();
		assertEquals(answer5, candidate5);

		RabinKarp rk6 = new RabinKarp(text, pattern6);
		candidate6 = rk6.getOccurences();
		assertEquals(answer6, candidate6);

		RabinKarp rk7 = new RabinKarp(text, pattern7);
		candidate7 = rk7.getOccurences();
		assertEquals(answer7, candidate7);

	}

	@Test
	public void testFinite () {
		PatternOccurences candidate1, candidate2, candidate3, candidate4, candidate5, candidate6, candidate7;

		FiniteStateMachineFinder machine1 = new FiniteStateMachineFinder(text, pattern1);
		candidate1 = machine1.getOccurences();
		assertEquals(answer1, candidate1);

		FiniteStateMachineFinder machine2 = new FiniteStateMachineFinder(text, pattern2);
		candidate2 = machine2.getOccurences();
		assertEquals(answer2, candidate2);

		FiniteStateMachineFinder machine3 = new FiniteStateMachineFinder(text, pattern3);
		candidate3 = machine3.getOccurences();
		assertEquals(answer3, candidate3);

		FiniteStateMachineFinder machine4 = new FiniteStateMachineFinder(text, pattern4);
		candidate4 = machine4.getOccurences();
		assertEquals(answer4, candidate4);

		FiniteStateMachineFinder machine5 = new FiniteStateMachineFinder(text, pattern5);
		candidate5 = machine5.getOccurences();
		assertEquals(answer5, candidate5);

		FiniteStateMachineFinder machine6 = new FiniteStateMachineFinder(text, pattern6);
		candidate6 = machine6.getOccurences();
		assertEquals(answer6, candidate6);

		FiniteStateMachineFinder machine7 = new FiniteStateMachineFinder(text, pattern7);
		candidate7 = machine7.getOccurences();
		assertEquals(answer7, candidate7);
	}

	@Test
	public void testKMP () {
		PatternOccurences candidate1, candidate2, candidate3, candidate4, candidate5, candidate6, candidate7;

		KMP kmp1 = new KMP(text, pattern1);
		candidate1 = kmp1.getOccurences();
		assertEquals(answer1, candidate1);

		KMP kmp2 = new KMP(text, pattern2);
		candidate2 = kmp2.getOccurences();
		assertEquals(answer2, candidate2);

		KMP kmp3 = new KMP(text, pattern3);
		candidate3 = kmp3.getOccurences();
		assertEquals(answer3, candidate3);

		KMP kmp4 = new KMP(text, pattern4);
		candidate4 = kmp4.getOccurences();
		assertEquals(answer4, candidate4);

		KMP kmp5 = new KMP(text, pattern5);
		candidate5 = kmp5.getOccurences();
		assertEquals(answer5, candidate5);

		KMP kmp6 = new KMP(text, pattern6);
		candidate6 = kmp6.getOccurences();
		assertEquals(answer6, candidate6);

		KMP kmp7 = new KMP(text, pattern7);
		candidate7 = kmp7.getOccurences();
		assertEquals(answer7, candidate7);
	}

	@Test
	public void testBoyerMoore () {
		PatternOccurences candidate1, candidate2, candidate3, candidate4, candidate5, candidate6, candidate7;

		BoyerMoore bm1 = new BoyerMoore(text, pattern1);
		candidate1 = bm1.getOccurences();
		assertEquals(answer1, candidate1);

		BoyerMoore bm2 = new BoyerMoore(text, pattern2);
		candidate2 = bm2.getOccurences();
		assertEquals(answer2, candidate2);

		BoyerMoore bm3 = new BoyerMoore(text, pattern3);
		candidate3 = bm3.getOccurences();
		assertEquals(answer3, candidate3);

		BoyerMoore bm4 = new BoyerMoore(text, pattern4);
		candidate4 = bm4.getOccurences();
		assertEquals(answer4, candidate4);

		BoyerMoore bm5 = new BoyerMoore(text, pattern5);
		candidate5 = bm5.getOccurences();
		assertEquals(answer5, candidate5);

		BoyerMoore bm6 = new BoyerMoore(text, pattern6);
		candidate6 = bm6.getOccurences();
		assertEquals(answer6, candidate6);

		BoyerMoore bm7 = new BoyerMoore(text, pattern7);
		candidate7 = bm7.getOccurences();
		assertEquals(answer7, candidate7);
	}
}
