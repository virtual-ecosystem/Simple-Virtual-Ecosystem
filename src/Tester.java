import sve.test.TestManager;
import sve.test.core.CoreTestRecorder;
import sve.test.gui.GUITestRecorder;
import sve.test.stats.StatsTestRecorder;

/**
 * This class starts the tests of
 * SVE system
 *
 * @author repelliuss
 */
public class Tester {

	/**
	 *@param args Use command line arguments
	 *to start specific tests as this:
	 *<p>
	 *Default is all of the tests.
	 *<p>
	 *'0' for all of the tests.
	 *<p>
	 *'1' for tests of core module.
	 *<p>
	 *'2' for tests of stats module.
	 *<p>
	 *'3' for tests of gui module.
	 */
	public static void main(String[] args) {

		TestManager tm = new TestManager();

		if(args.length <= 0) {
			initAll(tm);
		}
		else {
			switch(args[0]) {
			case "1":
				initCore(tm);
				break;
			case "2":
				initStats(tm);
				break;
			case "3":
				initGUI(tm);
				break;
			default:
			case "0":
				initAll(tm);
				break;
			}
		}

		tm.start();
	}

	private static void initAll(TestManager tm) {
		initCore(tm);
		initStats(tm);
		initGUI(tm);
	}

	private static void initCore(TestManager tm) {
		CoreTestRecorder.recordAll(tm);
	}

	private static void initGUI(TestManager tm) {
		GUITestRecorder.recordAll(tm);
	}

	private static void initStats(TestManager tm) {
		StatsTestRecorder.recordAll(tm);
	}
}
