package sve.test;

import java.util.Queue;
import java.util.LinkedList;

public class TestManager {

	private Queue<Test> testQueue;

	public TestManager() {
		testQueue = new LinkedList<>();
	}

	public void register(Test test) {
		testQueue.add(test);
	}

	public void start() {

		Queue<Test> temp = new LinkedList<>();

		while(!testQueue.isEmpty()) {
			temp.add(testQueue.remove());
			doTest(temp.element());
		}

		testQueue = temp;
	}

	private void doTest(Test test) {
		System.out.println("Testing " + test.methodName
						   + ": " + testResultInfo(test.method.getAsBoolean()) + '\n');
	}

	private String testResultInfo(boolean result) {

		if(result)
			return "Passed";

		return "!!!FAILED!!!";
	}
}
