import ch.hepia.it.PatternFinding.DataStructures.PatternOccurences;
import ch.hepia.it.PatternFinding.Engine.BoyerMoore;
import ch.hepia.it.PatternFinding.Engine.FiniteStateMachineFinder;
import ch.hepia.it.PatternFinding.Engine.KMP;
import ch.hepia.it.PatternFinding.Engine.RabinKarp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	public static void main (String[] args) throws IOException, NumberFormatException {
		// Ne pas modifier cette partie
		String fileName = null;
		String motif = null;
		String data = "";
		int algo = 0;
		switch (args.length) {
			case 3:
				fileName = args[2];
				data = new String(Files.readAllBytes(Paths.get(fileName)));
			case 2:
				algo = Integer.parseInt(args[1]);
				motif = args[0];
				break;
			default:
				System.err.println("usage: java Main <motif> <algo> (<fichier_texte>)");
				System.exit(1);
		}
		switch (algo) {
			case 1: //Rabin-Karp
				RabinKarp karp = new RabinKarp(data, motif);
				if (fileName == null) {
					System.out.println(karp.getBase() + " " + karp.getQ() + " " + karp.getP());
				} else {
					PatternOccurences results = karp.getOccurences();
					System.out.println(results);
				}
				break;
			case 2: //Automate fini
				FiniteStateMachineFinder finiteFinder = new FiniteStateMachineFinder(data, motif);
				if (fileName == null) {
					finiteFinder.printStates();
				} else {
					PatternOccurences results = finiteFinder.getOccurences();
					System.out.println(results);
				}
				break;
			case 3: //Knut-Morris-Pratt
				KMP kmp = new KMP(data, motif);
				if (fileName == null) {
					kmp.printPiArray();
				} else {
					PatternOccurences results = kmp.getOccurences();
					System.out.println(results);
				}
				break;
			case 4: //Boyer-Moore
				BoyerMoore bm = new BoyerMoore(data, motif);
				if (fileName == null) {
					bm.displayTabs();
				} else {
					PatternOccurences results = bm.getOccurences();
					System.out.println(results);
				}
				break;
			default:
				System.err.println("Algorithm not implemented");
				System.exit(2);
		}
	}
}











