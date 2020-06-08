package sve.test.core;

import sve.test.TestManager;
import sve.test.Test;
import sve.test.sample.TestExample;

/**
 * Utility class to register the
 * tests of Core module of
 * SVE system to TestManager
 *
 * @author repelliuss
 */
public class CoreTestRecorder {

	/**
	 * Register your unit tests here!
     */
	public static void recordAll(TestManager tester) {
		tester.register(new Test("exampleTest", () -> TestExample.exampleTest()));
	}
}
