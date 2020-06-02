package sve.test;

import java.util.function.BooleanSupplier;

/**
 * A class to hold properties
 * of a unit test
 *
 * @author repelliuss
 */
public class Test {

	String methodName;
	BooleanSupplier method;

	public Test(String methodName, BooleanSupplier method) {
		this.methodName = methodName;
		this.method = method;
	}
}
