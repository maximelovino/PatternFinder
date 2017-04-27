package ch.hepia.it.PatternFinding.Engine;

import java.util.List;

/**
 * @author Maxime Lovino
 * @date 27.04.17
 * @package ch.hepia.it.PatternFinding.Engine
 * @project PatternFinding
 */

public interface PatternFinder {

	List<Integer> getOccurences (String text, String pattern);
}
