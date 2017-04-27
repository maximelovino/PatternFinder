package ch.hepia.it.PatternFinding.Test;

import ch.hepia.it.PatternFinding.Engine.RabinKarp;

public class TestFile {
	public static void main (String[] args) {
		String text = "HhhellohelloHhhellohelloHhhellohelloHhhellohelloHhhellohelloHhhellohelloHhhellohelloHhhellohello";
		String pattern = "hello";

		System.out.println(RabinKarp.getInstance().getOccurences(text, pattern));
	}
}
