package ch.hepia.it.PatternFinding.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import ch.hepia.it.PatternFinding.Engine.BoyerMoore;
import ch.hepia.it.PatternFinding.Engine.FiniteStateMachineFinder;
import ch.hepia.it.PatternFinding.Engine.KMP;
import ch.hepia.it.PatternFinding.Engine.RabinKarp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UnitTest {
	String fileName = "tests/data.txt";
	String text = new String(Files.readAllBytes(Paths.get(fileName)));
	String pattern1 = "1212";
	String pattern2 = "wwww";
	String pattern3 = "bonsbonsbons";
	String pattern4 = "1111abt1111ab";
	List<Integer> answer1, answer2, answer3, answer4;


	public UnitTest () throws IOException {
		answer1 = TestFile.naiveAlgo(text, pattern1);
		answer2 = TestFile.naiveAlgo(text, pattern2);
		answer3 = TestFile.naiveAlgo(text, pattern3);
		answer4 = TestFile.naiveAlgo(text, pattern4);
	}

	@Test
	public void testKarp () {
		List<Integer> candidate1, candidate2, candidate3, candidate4;

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

	}

	@Test
	public void testFinite () {
		List<Integer> candidate1, candidate2, candidate3, candidate4;

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

	}

	@Test
	public void testKMP () {
		List<Integer> candidate1, candidate2, candidate3, candidate4;

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

	}

	@Test
	public void testBoyerMoore () {
		List<Integer> candidate1, candidate2, candidate3, candidate4;

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

	}
}
